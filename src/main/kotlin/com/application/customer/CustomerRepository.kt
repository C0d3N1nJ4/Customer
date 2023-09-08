package com.application.customer

import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long> {

    override fun findAll(): Iterable<Customer>
    fun findById(id: Int): Customer


}