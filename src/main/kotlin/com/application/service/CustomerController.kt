package com.application.service

import com.application.customer.Customer
import com.application.exceptions.CustomerNotFoundException
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
        //retrieve customer by id from customerService and assign it to a variable
        var customer = customerService.getCustomerById(id)

        if (customer.isPresent) {
            return customer
        } else {
              throw CustomerNotFoundException(id)
        }
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

    @PutMapping("/customer/{id}")
    @ResponseBody
    fun updateCustomer(@RequestBody customer : Customer, @PathVariable id: Int) {
        var customerToUpdate = customerService.getCustomerById(id)
        if (customerToUpdate.isPresent) {
            customerToUpdate.get().firstName = customer.firstName
            customerToUpdate.get().lastName = customer.lastName
            customerToUpdate.get().email = customer.email
            customerService.createCustomer(customerToUpdate.get())
        } else {
            throw CustomerNotFoundException(id)
        }
    }

}