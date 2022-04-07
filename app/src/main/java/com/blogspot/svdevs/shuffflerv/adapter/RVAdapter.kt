package com.blogspot.svdevs.shuffflerv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.svdevs.shuffflerv.data.Uidata
import com.blogspot.svdevs.shuffflerv.data.ViewData
import com.blogspot.svdevs.shuffflerv.databinding.ItemLayoutBinding

class RVAdapter(
//    private var dataList: ArrayList<ViewData>,
    private var dataList: ArrayList<Uidata>,
) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem, position)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Uidata, position: Int) {

//            val dataValue = data.uidata[position]

            if (data.uitype.equals("label")) {
                binding.tvValue.text = data.value
                binding.tvViewType.text = data.uitype
                binding.tvKey.text = data.key
            } else if (data.uitype.equals("edittext")) {
                binding.tvValue.text = data.hint
                binding.tvViewType.text = data.uitype
                binding.tvKey.text = data.key
            } else if (data.uitype.equals("button")) {
                binding.tvValue.text = data.value
                binding.tvViewType.text = data.uitype
            }

        }

    }

}