package com.application.contact

import jakarta.persistence.Entity
import jakarta.persistence.Id
@Entity
data class Contact (
    @Id
    var id: String,
    var email : String,
    var phone : String
)