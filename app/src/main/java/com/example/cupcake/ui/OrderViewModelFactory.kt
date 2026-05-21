package com.example.cupcake.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cupcake.data.AppDatabase
import com.example.cupcake.data.OrderRepository

class OrderViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = AppDatabase.getDatabase(context).orderDao()
        val repository = OrderRepository(dao)

        return OrderViewModel(repository) as T
    }
}
