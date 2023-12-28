package com.application.customer

import com.application.exceptions.CustomerNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@Controller
@RequestMapping("/api")
class CustomerController @Autowired constructor(private val customerService: CustomerServiceImpl) {

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

    @GetMapping("/customers/{status}")
    @ResponseBody
    fun getCustomersByStatus(@PathVariable status: String): Iterable<Customer> {
        return customerService.getCustomersByStatus(status)
    }

    @PostMapping("/customer")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer : Customer): Customer {
        return customerService.createCustomer(customer)
    }

    @PutMapping("/customer/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun updateCustomer(@RequestBody customer : Customer, @PathVariable id: Int) {
        var customerToUpdate = customerService.getCustomerById(id)
        if (customerToUpdate.isPresent) {
            customerToUpdate.get().name = customer.name
            customerToUpdate.get().lastname = customer.lastname
            customerToUpdate.get().email = customer.email
            customerToUpdate.get().status = customer.status
            customerService.createCustomer(customerToUpdate.get())
        } else {
            throw CustomerNotFoundException(id)
        }
    }

}