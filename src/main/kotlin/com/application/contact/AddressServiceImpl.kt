package com.application.contact

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import java.util.*


@Service
class AddressServiceImpl(private val addressRepository: AddressRepository) {
    fun findById(id: String): Optional<Address?>? {
        val address = addressRepository.findById(id)
        return if (address.isPresent) {
            address
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    fun createAddress(address: Address): Address {
        return addressRepository.save(address)
    }

    fun updateAddress(address: Address): Address {
        return addressRepository.save(address)
    }
}
