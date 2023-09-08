package com.application.service

import com.application.customer.Customer
import com.application.customer.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api")
class CustomerController(@Autowired private val customerRepository: CustomerRepository) {

    @GetMapping("/customer/{id}")
    fun getCustomerById(): Customer {
        return customerRepository.findById(1)
    }

    @GetMapping("/customers")
    fun getCustomers(): Iterable<Customer> {
        return customerRepository.findAll()
    }

}