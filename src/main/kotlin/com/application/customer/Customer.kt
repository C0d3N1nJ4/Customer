package com.application.customer


import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Customer(
    @Id
    val id: Int,
    var firstName: String,
    var lastName: String,
    var email: String,
    var status: String = "active"
)
