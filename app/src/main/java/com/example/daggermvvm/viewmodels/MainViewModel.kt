package com.example.daggermvvm.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggermvvm.model.Product
import com.example.daggermvvm.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {

    val productLiveData: LiveData<List<Product>>
        get() = repository.product

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}

class Randomize @Inject constructor() {
    fun doAction() {
        Log.d("DaggerMVVM", "Random Action")
    }
}