package com.application.exceptions

class StatusNotFoundException(status: String) : RuntimeException("Status $status not found")