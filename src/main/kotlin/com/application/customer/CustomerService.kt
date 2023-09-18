package com.application.customer

import com.application.customer.Customer
import org.springframework.stereotype.Service
import java.util.*

@Service
interface CustomerService {

    fun getAllCustomers(): List<Customer>

    fun getCustomerById(id: Int): Optional<Customer>

    fun createCustomer(customer: Customer): Customer


}