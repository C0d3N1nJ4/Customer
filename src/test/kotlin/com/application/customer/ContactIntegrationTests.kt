package com.application.customer

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
class ContactIntegrationTests {

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
    @Throws(Exception::class)
    fun getAllContactsTest_StatusOK() {
        mockMvc!!.perform(MockMvcRequestBuilders.get("/contact").contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun getContactById_StatusOK() {
        mockMvc!!.perform(MockMvcRequestBuilders.get("/contact/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun getContactById_StatusNotFound() {
        mockMvc!!.perform(MockMvcRequestBuilders.get("/contact/66").contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
    }


    @Test
    @Throws(Exception::class)
    fun saveContact_StatusCREATED() {
        mockMvc!!.perform(
            MockMvcRequestBuilders.post("/contact")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                                {
                                    "id": "6",
                                    "street": "STREETSIX",
                                    "number": "6",
                                    "suburb": "PAULSHOF",
                                    "city": "SANDTON",
                                    "postalCode": "1234"
                                }
                                """.trimIndent()
                )
        )
            .andExpect(MockMvcResultMatchers.status().isCreated())
    }

}