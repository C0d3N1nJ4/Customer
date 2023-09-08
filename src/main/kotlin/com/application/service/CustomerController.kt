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

    @GetMapping("/customer")
    fun getCustomer(): Customer {
        return Customer(1, "John", "Doe", "")
    }


}