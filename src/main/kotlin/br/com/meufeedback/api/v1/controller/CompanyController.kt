package br.com.meufeedback.api.v1.controller

import br.com.meufeedback.api.v1.payload.company.request.CompanyRequest
import br.com.meufeedback.api.v1.payload.company.response.CompanyResponse
import br.com.meufeedback.service.CompanyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("companies")
class CompanyController(private val companyService: CompanyService) {

    @GetMapping
    fun getCompanies(): List<CompanyResponse> {
        return companyService.findAll()
    }

    @GetMapping("/{companyId}")
    fun getCompanyById(
        @PathVariable companyId: Long
    ): ResponseEntity<CompanyResponse> {
        val companyResponse: CompanyResponse = companyService.findById(companyId)
        return ResponseEntity<CompanyResponse>(companyResponse, null, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody companyRequest: CompanyRequest): ResponseEntity<CompanyResponse> {
        val companyResponse
                : CompanyResponse = companyService.save(companyRequest)

        return ResponseEntity<CompanyResponse>(companyResponse, null, HttpStatus.CREATED)
    }

    @PutMapping("/{companyId}")
    fun update(
        @RequestBody companyRequest: CompanyRequest,
        @PathVariable companyId: Long
    ): ResponseEntity<CompanyResponse> {
        val companyResponse
                : CompanyResponse = companyService.update(companyRequest, companyId)

        return ResponseEntity<CompanyResponse>(companyResponse, null, HttpStatus.CREATED)
    }

    @DeleteMapping("/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable companyId: Long) {
        companyService.delete(companyId)
    }
}
