package com.example.learnrecyclerview

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T,V : BaseViewHolder<T>>:RecyclerView.Adapter<V>() {
    abstract var items : MutableList<T>

    abstract var clickItemListener: (T) -> Unit

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.binData(items[position])
    }
}