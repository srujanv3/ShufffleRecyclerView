package com.blogspot.svdevs.shuffflerv.adapter

import android.content.Context
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.svdevs.shuffflerv.R
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
        val context = holder.itemView.context
        holder.bind(currentItem, context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Uidata, context: Context) {

//            val dataValue = data.uidata[position]

            if (data.uitype.equals("label")) {
                binding.titleTextLayout.visibility = View.VISIBLE
                binding.tvTitle.text = data.value
                binding.etLayout.visibility = View.GONE
                binding.btnLayout.visibility = View.GONE

            } else if (data.uitype.equals("edittext")) {
                binding.etLayout.visibility = View.VISIBLE
                binding.labelInput.hint = data.hint
                binding.titleTextLayout.visibility = View.GONE
                binding.btnLayout.visibility = View.GONE

                // for setting up inputType and drawable icons wrt key_type
                when(data.key) {
                    "text_name" -> {
                        binding.apply {
                            labelInput.startIconDrawable = ContextCompat.getDrawable(context,R.drawable.user)
                            titleInputValue.inputType = InputType.TYPE_CLASS_TEXT
                        }
                    }
                    "text_phone" -> {
                        binding.apply {
                            labelInput.startIconDrawable = ContextCompat.getDrawable(context,R.drawable.phone)
                            titleInputValue.inputType = InputType.TYPE_CLASS_NUMBER
                        }
                    }
                    "text_city" -> {
                        binding.apply {
                            labelInput.startIconDrawable = ContextCompat.getDrawable(context,R.drawable.city)
                            titleInputValue.inputType = InputType.TYPE_CLASS_TEXT
                        }
                    }
                }

            } else if (data.uitype.equals("button")) {
                binding.btnLayout.visibility = View.VISIBLE
                binding.btnLayout.text = data.value
                binding.etLayout.visibility = View.GONE
                binding.titleTextLayout.visibility = View.GONE
            }

        }

    }

}