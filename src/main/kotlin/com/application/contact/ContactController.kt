package com.application.contact

import com.application.exceptions.ContactNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contact")
class ContactController {

    private final val contactService: ContactServiceImpl = ContactServiceImpl()

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getContacts(): List<Contact?>? {
        return contactService.findAll()
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getContactById(@PathVariable("id") id: String): Contact? {
        return contactService.findById(id) ?: throw ContactNotFoundException(id)
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun createContact(@RequestBody contact: Contact): Contact? {
        return contactService.create(contact)
    }


}