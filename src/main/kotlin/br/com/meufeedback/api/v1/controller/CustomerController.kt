package br.com.meufeedback.api.v1.controller

import br.com.meufeedback.api.v1.payload.customer.request.CustomerRequest
import br.com.meufeedback.api.v1.payload.customer.response.CustomerResponse
import br.com.meufeedback.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getCompanies(): List<CustomerResponse> {
        return customerService.findAll()
    }

    @GetMapping("/{customerId}")
    fun getCustomerById(
        @PathVariable customerId: Long
    ): ResponseEntity<CustomerResponse> {
        val customerResponse: CustomerResponse = customerService.findById(customerId)
        return ResponseEntity<CustomerResponse>(customerResponse, null, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody customerRequest: CustomerRequest): ResponseEntity<CustomerResponse> {
        val customerResponse
                : CustomerResponse = customerService.save(customerRequest)

        return ResponseEntity<CustomerResponse>(customerResponse, null, HttpStatus.CREATED)
    }

    @PutMapping("/{customerId}")
    fun update(
        @RequestBody customerRequest: CustomerRequest,
        @PathVariable customerId: Long
    ): ResponseEntity<CustomerResponse> {
        val customerResponse
                : CustomerResponse = customerService.update(customerRequest, customerId)

        return ResponseEntity<CustomerResponse>(customerResponse, null, HttpStatus.CREATED)
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable customerId: Long) {
        customerService.delete(customerId)
    }
}
