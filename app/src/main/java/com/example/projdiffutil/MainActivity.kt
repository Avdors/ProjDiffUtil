package com.example.projdiffutil

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projdiffutil.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var mDetector: GestureDetectorCompat
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = ItemAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //для того чтобы обработать нажатия
        mDetector = GestureDetectorCompat(this, this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = CustomItemAnimator()

        viewModel.items.observe(this, {items ->
            adapter.submitList((items))
        })

        binding.btUpdate.setOnClickListener{

            val sharedPref = this.getSharedPreferences(
                getString(R.string.preference_key), Context.MODE_PRIVATE)
            val editor = sharedPref.edit();
            val oldvalue = sharedPref.getInt(getString(R.string.save_key), 0)
            if(oldvalue == 1){
                editor.putInt(getString(R.string.save_key), 2)
                viewModel.updateItems(2)
            }else{
                editor.putInt(getString(R.string.save_key), 1)
                viewModel.updateItems(1)
            }
            editor.apply()

        }

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if(mDetector.onTouchEvent(event)){
            true
        } else{
            super.onTouchEvent(event)
        }

    }

    override fun onDown(e: MotionEvent): Boolean {
        return true
    }

    override fun onShowPress(e: MotionEvent) {

    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return true
    }

    override fun onLongPress(e: MotionEvent) {
        Toast.makeText(this, "Длительное нажатие", Toast.LENGTH_SHORT).show()
    }


    // здесь обрабатываем скольжение
    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        return true
    }
}