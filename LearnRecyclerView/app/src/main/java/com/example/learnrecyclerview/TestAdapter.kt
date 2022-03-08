package com.example.learnrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView

class TestAdapter(
    override var items: MutableList<Int>,
    override var clickItemListener: (Int) -> Unit
) : BaseAdapter<Int, TestAdapter.TestViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TestViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false),
        clickItemListener
    )

    class TestViewHolder(itemview: View, override var clickItemListener: (Int) -> Unit) :
        BaseViewHolder<Int>(itemview) {
        override fun binData(item: Int) {
            super.binData(item)

            itemView.findViewById<TextView>(R.id.textview).text = item.toString()

        }
    }


}