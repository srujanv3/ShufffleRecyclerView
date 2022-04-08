package com.blogspot.svdevs.shuffflerv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.blue002)
    }
}