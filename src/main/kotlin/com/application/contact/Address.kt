package com.application.contact

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Address(
    @Id
    val id: String,
    var street: String,
    var number: String,
    var suburb: String,
    var postalCode: String
)