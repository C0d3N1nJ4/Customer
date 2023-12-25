package com.application.address

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/address")
class AddressController(addressService: AddressServiceImpl) {
    private val addressServiceImpl: AddressServiceImpl

    init {
        this.addressServiceImpl = addressService
    }

    @GetMapping("/{address-id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getAddressById(@PathVariable("address-id") id: String): Optional<Address?>? {
        return addressServiceImpl.findById(id)
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun createAddress(@RequestBody address: Address): Address {
        return addressServiceImpl.createAddress(address)
    }

    @PutMapping("/{address-id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun updateAddress(@PathVariable("address-id") id: String, @RequestBody address: Address): Address {
        return addressServiceImpl.updateAddress(address)
    }

}