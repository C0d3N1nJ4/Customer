package com.application.contact

import org.springframework.stereotype.Service
import java.util.*


@Service
interface AddressService {
    fun findById(id: String?): Optional<Address?>?
}
