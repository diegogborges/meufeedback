package br.com.meufeedback.api.v1.controller

import br.com.meufeedback.api.v1.payload.company.request.CompanyRequest
import br.com.meufeedback.api.v1.payload.company.response.CompanyResponse
import br.com.meufeedback.domain.User
import br.com.meufeedback.service.CompanyService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.time.LocalDateTime

class CompanyControllerTest {

    lateinit var mockMvc: MockMvc

    @MockK
    lateinit var companyService: CompanyService

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
        this.mockMvc = MockMvcBuilders.standaloneSetup(CompanyController(companyService)).build()
    }

    @Test
    fun `test save company with success`() {
        every {
            companyService.save(
                CompanyRequest(
                    "Company name",
                    "5516992507202",
                    listOf(1)
                )
            )
        } returns CompanyResponse(
            1, "Company name", "5516992507202", LocalDateTime.now(), LocalDateTime.now(), listOf(
                User(
                    1,
                    "Diego",
                    "diegogb2013@gmail.com",
                    "Diego Gomes",
                    "Borges",
                    "1234",
                    LocalDateTime.now(),
                    LocalDateTime.now()
                )
            )
        )

        val requestBody = "{\"name\":\"Company name\", \"phone\":\"5516992507202\", \"users\":[1]}"

        mockMvc.perform(
            MockMvcRequestBuilders.post("/companies")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(MockMvcResultMatchers.status().isCreated)
    }

    @Test
    fun `test find all companies with success`() {
        every {companyService.findAll() } returns listOf(CompanyResponse(
            1, "Company name", "5516992507202", LocalDateTime.now(), LocalDateTime.now(), listOf(
                User(
                    1,
                    "Diego",
                    "diegogb2013@gmail.com",
                    "Diego Gomes",
                    "Borges",
                    "1234",
                    LocalDateTime.now(),
                    LocalDateTime.now()
                )
            )
        ))

        mockMvc.perform(
            MockMvcRequestBuilders.get("/companies")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun `test find by id company with success`() {
        every {companyService.findById(2) } returns CompanyResponse(
            2, "Company name 2", "5516992507202", LocalDateTime.now(), LocalDateTime.now(), listOf(
                User(
                    1,
                    "Diego",
                    "diegogb2013@gmail.com",
                    "Diego Gomes",
                    "Borges",
                    "1234",
                    LocalDateTime.now(),
                    LocalDateTime.now()
                )
            )
        )

        mockMvc.perform(
            MockMvcRequestBuilders.get("/companies/2")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(MockMvcResultMatchers.status().isOk)
    }
}
