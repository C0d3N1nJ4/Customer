package com.application.exceptions


class CustomerNotFoundException(customerId: Int) : RuntimeException("Customer with id $customerId not found")