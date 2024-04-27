package br.com.meufeedback.service.impl

import br.com.meufeedback.api.v1.payload.customer.request.CustomerRequest
import br.com.meufeedback.api.v1.payload.customer.response.CustomerResponse
import br.com.meufeedback.domain.Customer
import br.com.meufeedback.domain.User
import br.com.meufeedback.exception.NotFoundException
import br.com.meufeedback.repository.CustomerRepository
import br.com.meufeedback.repository.UserRepository
import br.com.meufeedback.service.CustomerService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository
): CustomerService {

    override fun save(customerRequest: CustomerRequest): CustomerResponse {
        var customer = Customer(
            name = customerRequest.name,
            email = customerRequest.email,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        customer = customerRepository.save(customer)
        return prepareResponse(customer)
    }

    override fun update(customerRequest: CustomerRequest, customerId: Long): CustomerResponse {
        var customer: Customer = this.findByIdOrThrow(customerId)
        customer = Customer(
            name = customerRequest.name,
            email = customerRequest.email,
            createdAt = customer.createdAt,
            updatedAt = LocalDateTime.now()
        )

        customer = customerRepository.save(customer)
        return prepareResponse(customer)
    }

    override fun delete(customerId: Long) {
        val customer: Customer = this.findByIdOrThrow(customerId)
        customerRepository.delete(customer)
    }

    override fun findAll(): List<CustomerResponse> {
        val companies: List<Customer> = customerRepository.findAll()

        val customerResponses = ArrayList<CustomerResponse>()
        companies.forEach { customer -> customerResponses.add(prepareResponse(customer)) }
        return customerResponses
    }

    override fun findById(customerId: Long): CustomerResponse {
        val customer: Customer = this.findByIdOrThrow(customerId)
        return prepareResponse(customer)
    }

    override fun findByIdOrThrow(customerId: Long): Customer {
        return customerRepository.findById(customerId)
            .orElseThrow {
                NotFoundException(
                    String.format("Customer with id: %s not found!", customerId)
                )
            }
    }

    private fun prepareResponse(customer: Customer): CustomerResponse {
        return CustomerResponse(
            customer.id!!, customer.name, customer.email,
            customer.createdAt!!, customer.updatedAt!!
        )
    }
}
