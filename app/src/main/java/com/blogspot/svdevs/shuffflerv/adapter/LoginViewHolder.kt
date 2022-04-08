package com.blogspot.svdevs.shuffflerv.adapter

import android.content.Context
import android.text.InputType
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.blogspot.svdevs.shuffflerv.R
import com.blogspot.svdevs.shuffflerv.data.Uidata
import com.blogspot.svdevs.shuffflerv.databinding.ButtonLayoutBinding
import com.blogspot.svdevs.shuffflerv.databinding.EditTextLayoutBinding
import com.blogspot.svdevs.shuffflerv.databinding.TitleLayoutBinding

sealed class LoginViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class TitleViewHolder(private val binding: TitleLayoutBinding) :
        LoginViewHolder(binding) {
        fun bind(data: Uidata, context: Context) {
            if (data.uitype.equals("label")) {
                binding.tvTitle.text = data.value
            }
        }
    }

    class EditTextViewHolder(private val binding: EditTextLayoutBinding) :
        LoginViewHolder(binding) {

        fun bind(data: Uidata, context: Context) {
            if (data.uitype.equals("edittext")) {
                binding.labelInput.hint = data.hint

                // for setting up inputType and drawable icons wrt key_type
                when (data.key) {
                    "text_name" -> {
                        binding.apply {
                            labelInput.startIconDrawable =
                                ContextCompat.getDrawable(context, R.drawable.user)
                            titleInputValue.inputType = InputType.TYPE_CLASS_TEXT
                        }
                    }
                    "text_phone" -> {
                        binding.apply {
                            labelInput.startIconDrawable =
                                ContextCompat.getDrawable(context, R.drawable.phone)
                            labelInput.prefixText = "+91"
                            titleInputValue.inputType = InputType.TYPE_CLASS_NUMBER
                        }
                    }
                    "text_city" -> {
                        binding.apply {
                            labelInput.startIconDrawable =
                                ContextCompat.getDrawable(context, R.drawable.city)
                            titleInputValue.inputType = InputType.TYPE_CLASS_TEXT
                        }
                    }
                }
            }
        }
    }

        class ButtonViewHolder(private val binding: ButtonLayoutBinding) :
            LoginViewHolder(binding) {
            fun bind(data: Uidata, context: Context) {
                if (data.uitype.equals("button")) {
                    binding.btnLayout.text = data.value
                }
            }
        }
    }
