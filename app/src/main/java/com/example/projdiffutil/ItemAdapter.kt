package com.example.projdiffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projdiffutil.databinding.ItemViewBinding

class ItemAdapter: ListAdapter<Item, ItemAdapter.ItemViewHolder>(DiffCallback()) {



    class ItemViewHolder(private val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item){
            binding.itemName.text = item.name
        }

    }

    class DiffCallback: DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            // Используется для определения, представляют ли два объекта один и тот же элемент списка.
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            // Используется для определения, имеют ли два элемента одинаковое содержание.
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


}