package com.application.customer


import com.application.address.Address
import com.application.contact.Contact
import jakarta.persistence.*

@Entity
data class Customer(
    @Id
    val id: Int,
    var name: String,
    var lastname: String,
    var email: String,
    var status: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id")
    val address: Address?,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "contact_id")
    val contact: Contact?
)
