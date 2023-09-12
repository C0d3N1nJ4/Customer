package com.application.exceptions


class CustomerNotFoundException : RuntimeException() {
    fun CustomerNotFoundException(id: Int): String {
        return "Customer with id $id not found"
    }
}