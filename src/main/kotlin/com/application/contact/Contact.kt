package com.application.contact

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Contact(
    @Id
    val id: Int,
    var email: String,
    var phone: String,
)
