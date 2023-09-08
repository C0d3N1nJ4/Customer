package com.application.service

import com.application.customer.Customer

interface CustomerService {
    fun getCustomer(): Customer

    fun getCustomers(): List<Customer>

    fun getCustomerById(id: Int): Customer


}