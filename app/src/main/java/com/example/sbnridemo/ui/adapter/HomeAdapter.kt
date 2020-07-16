package com.example.sbnridemo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sbnridemo.R
import com.example.sbnridemo.databinding.RowItemLayoutBinding
import com.example.sbnridemo.model.RowModel
import java.util.*

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ItemViewHolder> {

    lateinit var dataList: List<RowModel?>
    lateinit var mContext: Context

    constructor(context: Context, dataList: ArrayList<RowModel?>) {
        this.dataList = dataList
        this.mContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: RowItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.row_item_layout,
            parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.binding.rows = dataList.get(position)
    }

    class ItemViewHolder(binding: RowItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        val binding = binding
    }
}