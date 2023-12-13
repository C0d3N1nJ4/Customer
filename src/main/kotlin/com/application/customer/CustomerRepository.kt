package com.application.customer

import org.springframework.data.repository.CrudRepository
import java.util.*

interface CustomerRepository : CrudRepository<Customer, Int> {

    override fun findAll(): List<Customer>
    override fun findById(id: Int): Optional<Customer>
    fun save(customer: Customer): Customer
    fun findCustomersByStatus(s: String): List<Customer>

}