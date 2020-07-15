package com.example.sbnridemo.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brijesh.testdemo.model.RowModel
import java.util.*


class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ItemViewHolder>() {

    private var dataList: ArrayList<RowModel?>? = null
    private var mContext: Context? = null

    fun HomeAdapter(
        context: Context?,
        dataList: ArrayList<RowModel?>?
    ) {
        this.dataList = dataList
        mContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    }

    override fun getItemCount(): Int {
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}
}