package com.example.projdiffutil

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class CustomItemAnimator: DefaultItemAnimator() {

    override fun animateAdd(holder: RecyclerView.ViewHolder?): Boolean {

        holder?.itemView?.alpha = 0f
        holder?.itemView?.animate()?.alpha(1f)?.setDuration(300)?.start()
        return super.animateAdd(holder)
    }

    override fun animateChange(
        oldHolder: RecyclerView.ViewHolder?,
        newHolder: RecyclerView.ViewHolder?,
        fromX: Int,
        fromY: Int,
        toX: Int,
        toY: Int
    ): Boolean {
        if(oldHolder != null && newHolder != null){
            newHolder.itemView.alpha = 0f
            newHolder.itemView.animate().alpha(1f).setDuration(300).start()
        }
        return super.animateChange(oldHolder, newHolder, fromX, fromY, toX, toY)
    }
}