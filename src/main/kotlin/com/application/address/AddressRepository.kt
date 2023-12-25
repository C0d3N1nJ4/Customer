package com.application.address

import com.application.address.Address
import org.springframework.data.jpa.repository.JpaRepository
interface AddressRepository : JpaRepository<Address?, String?>