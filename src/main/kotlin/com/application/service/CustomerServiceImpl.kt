package com.application.service

import com.application.customer.Customer
import com.application.customer.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerServiceImpl(private val customerRepository: CustomerRepository) : CustomerService {
    override fun getCustomer(): Customer {
        TODO("Not yet implemented")
    }

    override fun getCustomers(): List<Customer> {
        TODO("Not yet implemented")
    }

    override fun getCustomerById(id: Int): Customer {
        TODO("Not yet implemented")
    }
}