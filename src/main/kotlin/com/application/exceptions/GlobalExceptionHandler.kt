package com.application.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@RestControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(CustomerNotFoundException::class)
    fun handleCustomerNotFoundException(e: CustomerNotFoundException): ProblemDetail? {
        val problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.NOT_FOUND,
            e.message!!
        )
        problemDetail.title = "Customer not found"
        return problemDetail
    }

    @ExceptionHandler(StatusNotFoundException::class)
    fun handleStatusNotFoundException(e: StatusNotFoundException): ProblemDetail? {
        val problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.NOT_FOUND,
            e.message!!
        )
        problemDetail.title = "Status not found"
        return problemDetail
    }

    @ExceptionHandler(ContactNotFoundException::class)
    fun handleContactNotFoundException(e: ContactNotFoundException): ProblemDetail? {
        val problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.NOT_FOUND,
            e.message!!
        )
        problemDetail.title = "Contact not found"
        return problemDetail
    }
}