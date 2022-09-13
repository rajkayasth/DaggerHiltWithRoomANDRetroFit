package com.example.daggermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.daggermvvm.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel



    private val product : TextView
    get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        (application as FakerApplication).applicationComponent.inject(this)
//
//        val map =  (application as FakerApplication).applicationComponent.getMap()

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.productLiveData.observe(this){
           product.text =  it.joinToString { x -> x.title + "\n\n" }
        }
    }
}