package com.application.customer

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
class CustomerIntegrationTests {
    private var mockMvc: MockMvc? = null

    @Autowired
    private val context: WebApplicationContext? = null
    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context!!)
            .build()
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun getAllCustomersTest_StatusOK() {
        mockMvc!!.perform(get("/api/customers").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun customerByIdTest_StatusOK(){
            mockMvc!!.perform(get("/api/customer/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        }

    @Test
    @Throws(Exception::class)
    fun customerByStatusTest_StatusOK() {
            mockMvc!!.perform(get("/api/customers/ACTIVE").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        }
    @Test
    @Throws(Exception::class)

    fun customerByStatusTest_StatusBadRequest() {
            mockMvc!!.perform(get("/api/customers/INACTIVE").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        }

    @Test
    @Throws(Exception::class)
    fun saveCustomer_StatusCREATED() {
        mockMvc!!.perform(
            post("/api/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                                {
                                    "id": 5,
                                    "name": "NAMEFIVE",
                                    "lastname": "LASTNAME",
                                    "email": "test@test.com",
                                    "status": "ACTIVE"
                                }
                                """)
        )
            .andExpect(status().isCreated())
            .andExpect(
                content().json(
                    """
                                {
                                    "id": 5,
                                    "name": "NAMEFIVE",
                                    "lastname": "LASTNAME",
                                    "email": "test@test.com",
                                    "status": "ACTIVE"
                                }
                                """.trimIndent()
                )
            )
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun saveCustomerWithAddress_StatusCREATED() {
        mockMvc!!.perform(
            post("/api/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""{
                                    "id": 6,
                                    "name": "NAMEFIVE",
                                    "lastname": "LASTNAME",
                                    "email" : "test@test.com",
                                    "status": "ACTIVE",
                                    "address": {
                                        "id": "6",
                                        "street": "STREET NAME",
                                        "number": "6",
                                        "suburb": "SUBURBSIX",
                                        "city": "VIENNA",
                                        "postalCode": "1234"
                                    }
                                }""")
        )
            .andExpect(status().isCreated())
            .andExpect(
                content().json(
                    """
                       {
                                    "id": 6,
                                    "name": "NAMEFIVE",
                                    "lastname": "LASTNAME",
                                    "email" : "test@test.com",
                                    "status": "ACTIVE",
                                    "address": {
                                        "id": "6",
                                        "street": "STREET NAME",
                                        "number": "6",
                                        "suburb": "SUBURBSIX",
                                        "city": "VIENNA",
                                        "postalCode": "1234"
                                    }
                                }
                                """.trimIndent()
                )
            )
    }
}