package com.example.learnrecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract var clickItemListener: (T) -> Unit

    open fun binData(item: T) {
        itemView.setOnClickListener { clickItemListener(item) }
    }


}