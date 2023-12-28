package com.application.contact

class ContactServiceImpl: ContactService {

    private var contactRepository: ContactRepository? = null

    fun ContactServiceImpl(contactRepository: ContactRepository?) {
        this.contactRepository = contactRepository
    }
    override fun findAll(): List<Contact?>? {
        return contactRepository!!.findAll();
    }

    override fun create(contact: Contact): Contact? {
        return contactRepository!!.save(contact)
    }

    override fun findById(id: String?): Contact? {
        return contactRepository!!.findById(id!!).orElse(null)
    }

    override fun update(contact: Contact): Contact? {
        return contactRepository!!.save(contact)
    }

    override fun deleteById(id: String?) {
        return contactRepository!!.deleteById(id!!)
    }

    override fun existsById(id: String?): Boolean? {
        return contactRepository!!.existsById(id!!)
    }
}