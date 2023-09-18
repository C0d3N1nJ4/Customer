package com.application.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class CustomerServiceImpl @Autowired constructor(
    private val customerRepository: CustomerRepository) : CustomerService {

    override fun getAllCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    override fun getCustomerById(id: Int): Optional<Customer>  {
        return customerRepository.findById(id)
    }

    override fun createCustomer(customer: Customer): Customer {
        return customerRepository.save(customer)
    }
}