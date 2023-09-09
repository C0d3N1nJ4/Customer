package com.application.service

import com.application.customer.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@Controller
@RequestMapping("/api")
class CustomerController @Autowired constructor(private val customerService: CustomerService) {

    @GetMapping("/customer/{id}")
    @ResponseBody
    fun getCustomerById(@PathVariable id: Int): Optional<Customer> {
        return customerService.getCustomerById(id)
    }

    @GetMapping("/customers")
    @ResponseBody
    fun getCustomers(): Iterable<Customer> {
        return customerService.getAllCustomers()
    }

    @PostMapping("/customer")
    @ResponseBody
    fun createCustomer(@RequestBody customer : Customer): Customer {
        return customerService.createCustomer(customer)
    }

}