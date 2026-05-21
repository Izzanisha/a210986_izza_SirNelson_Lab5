package com.example.cupcake.data

import kotlinx.coroutines.flow.Flow

class OrderRepository(private val orderDao: OrderDao) {

    val allOrders: Flow<List<OrderEntity>> = orderDao.getAllOrders()

    suspend fun insert(order: OrderEntity) {
        orderDao.insert(order)
    }
}