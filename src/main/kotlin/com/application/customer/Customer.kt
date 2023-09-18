package com.application.customer

import com.application.contact.Contact

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
data class Customer(
    @Id
    val id: Int,
    var firstName: String,
    var lastName: String,
    var email: String,
    var status: String = "active"
)
