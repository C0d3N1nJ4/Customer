package com.application.address

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Address(
    @Id
    val id: String,
    var street: String,
    var number: String,
    var suburb: String,
    var city: String,
    var postalCode: String
)
