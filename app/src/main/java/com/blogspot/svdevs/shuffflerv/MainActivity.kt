package com.blogspot.svdevs.shuffflerv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.blogspot.svdevs.shuffflerv.adapter.RVAdapter
import com.blogspot.svdevs.shuffflerv.data.Uidata
import com.blogspot.svdevs.shuffflerv.data.ViewData
import com.blogspot.svdevs.shuffflerv.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var UIlist: ArrayList<Uidata>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.blue002)

        UIlist = arrayListOf()

        UIlist.add(Uidata(uitype = "label", value = "Your Name", key = "label_name"))
        UIlist.add(Uidata(uitype = "edittext", hint = "Enter your name", key = "text_name"))
        UIlist.add(Uidata(uitype = "label", value = "Your Phone", key = "label_phone"))
        UIlist.add(Uidata(uitype = "edittext", hint = "Enter your phone", key = "text_phone"))
        UIlist.add(Uidata(uitype = "label", value = "Your City", key = "label_city"))
        UIlist.add(Uidata(uitype = "edittext", hint = "Enter your city", key = "text_city"))
        UIlist.add(Uidata(uitype = "button", value = "Submit"))


        binding.rvLayout.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
//            UIlist.shuffle()
            adapter = RVAdapter(UIlist)
        }

//        binding.fab.setOnClickListener {
//            startActivity(Intent(this, SecondActivity::class.java))
//        }
    }
}