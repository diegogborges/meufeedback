package br.com.meufeedback.service

import br.com.meufeedback.api.v1.payload.customer.request.CustomerRequest
import br.com.meufeedback.api.v1.payload.customer.response.CustomerResponse
import br.com.meufeedback.domain.Customer
import br.com.meufeedback.exception.NotFoundException
import br.com.meufeedback.repository.CustomerRepository
import br.com.meufeedback.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

interface CustomerService {

    fun save(customerRequest: CustomerRequest): CustomerResponse

    fun update(customerRequest: CustomerRequest, customerId: Long): CustomerResponse

    fun delete(customerId: Long)

    fun findAll(): List<CustomerResponse>

    fun findById(customerId: Long): CustomerResponse

    fun findByIdOrThrow(customerId: Long): Customer
}
