package com.application.address

import com.application.address.Address
import org.springframework.stereotype.Service
import java.util.*


@Service
interface AddressService {
    fun findById(id: String?): Optional<Address?>?
}
