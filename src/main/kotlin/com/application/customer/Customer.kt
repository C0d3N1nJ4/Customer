package com.application.customer


import com.application.address.Address
import jakarta.persistence.*

@Entity
data class Customer(
    @Id
    val id: Int,
    var firstName: String,
    var lastName: String,
    var email: String,
    var status: String = "active",

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_address_id")
    val address: Address?
)
