package com.application.customer

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
data class Customer(
    @Id
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String
)
