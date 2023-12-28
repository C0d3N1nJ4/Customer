package com.application.customer

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class CustomerTests(@Autowired val customerRepository: CustomerRepository) {

    @Test
    fun verifyCustomerCount() {
        val customers = customerRepository!!.findAll()
        assert(customers.size == 4)
    }

    @Test
    fun verifyCustomerStatusActive() {
        val customers: List<Customer> = customerRepository.findCustomersByStatus("ACTIVE")
        assert(customers.size == 2)
    }

    @Test
    fun verifyCustomerStatusInactive() {
        val customers: List<Customer> = customerRepository.findCustomersByStatus("INACTIVE")
        assert(customers.size == 2)
    }

    @Test
    fun testCustomerById() {
        val customer = customerRepository.findById(1).get()
        assert(customer.name.equals("NAMEONE"))
    }

    @Test
    fun testCustomerByIdNotFound() {
        val customer = customerRepository.findById(9).orElse(null)
        assert(customer == null)
    }
}


