package com.application.contact

import org.springframework.stereotype.Service

@Service
interface ContactService {

    fun findAll(): List<Contact?>?

    fun create(contact: Contact): Contact?

    fun findById(id: String?): Contact?

    fun update(contact: Contact): Contact?

    fun deleteById(id: String?)

    fun existsById(id: String?): Boolean?

}