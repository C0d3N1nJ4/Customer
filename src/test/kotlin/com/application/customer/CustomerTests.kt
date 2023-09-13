package com.application.customer

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class CustomerTests {

    @Autowired
    private val customerRepository: CustomerRepository? = null
    @Test
    fun verifyCustomerCount() {
        val customers = customerRepository!!.findAll()
        assert(customers.size == 5)
    }

    @Test
    fun testCustomerById() {
        val customer = customerRepository!!.findById(1).get()
        assert(customer.firstName == "John")
    }
}