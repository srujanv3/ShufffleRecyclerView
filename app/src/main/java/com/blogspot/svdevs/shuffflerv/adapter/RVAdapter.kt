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
import com.blogspot.svdevs.shuffflerv.databinding.ButtonLayoutBinding
import com.blogspot.svdevs.shuffflerv.databinding.EditTextLayoutBinding
import com.blogspot.svdevs.shuffflerv.databinding.ItemLayoutBinding
import com.blogspot.svdevs.shuffflerv.databinding.TitleLayoutBinding
import java.lang.IllegalArgumentException

class RVAdapter(
    private var dataList: ArrayList<Uidata>,
) : RecyclerView.Adapter<LoginViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginViewHolder {
        return when(viewType) {
            R.layout.title_layout -> LoginViewHolder.TitleViewHolder(
                TitleLayoutBinding.inflate(
                LayoutInflater.from(parent.context),parent,false))
            R.layout.edit_text_layout -> LoginViewHolder.EditTextViewHolder(
                EditTextLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),parent,false))
            R.layout.button_layout -> LoginViewHolder.ButtonViewHolder(
                ButtonLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),parent,false))

            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: LoginViewHolder, position: Int) {
        val currentItem = dataList[position]
        val context = holder.itemView.context
        when(holder) {
            is LoginViewHolder.TitleViewHolder -> holder.bind(currentItem,context)
            is LoginViewHolder.EditTextViewHolder -> holder.bind(currentItem,context)
            is LoginViewHolder.ButtonViewHolder -> holder.bind(currentItem,context)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(dataList[position].uitype){
             "label" -> R.layout.title_layout
             "edittext" -> R.layout.edit_text_layout
             "button" -> R.layout.button_layout
            else -> {throw IllegalStateException("No view found")}
        }

    }

}