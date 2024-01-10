package com.application.exceptions

class ContactNotFoundException (contactId: String) : RuntimeException("Contact with id $contactId not found") {
}