package br.com.meufeedback.service.impl

import br.com.meufeedback.api.v1.payload.company.request.CompanyRequest
import br.com.meufeedback.api.v1.payload.company.response.CompanyResponse
import br.com.meufeedback.domain.Company
import br.com.meufeedback.domain.User
import br.com.meufeedback.exception.NotFoundException
import br.com.meufeedback.repository.CompanyRepository
import br.com.meufeedback.repository.UserRepository
import br.com.meufeedback.service.CompanyService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CompanyServiceImpl(
    private val companyRepository: CompanyRepository,
    private val userRepository: UserRepository
): CompanyService {

    override fun save(companyRequest: CompanyRequest): CompanyResponse {
        val users: ArrayList<User> = getUsers(companyRequest)

        var company = Company(
            null,
            companyRequest.name,
            companyRequest.phone,
            users,
            LocalDateTime.now(),
            LocalDateTime.now()
        )

        company = companyRepository.save(company)
        return prepareResponse(company)
    }

    private fun getUsers(companyRequest: CompanyRequest): ArrayList<User> {
        val users: ArrayList<User> = arrayListOf()

        companyRequest.users.forEach {
            val user = userRepository.findById(it).get()
            users.add(user)
        }
        return users
    }

    override fun update(companyRequest: CompanyRequest, companyId: Long): CompanyResponse {
        val users: ArrayList<User> = getUsers(companyRequest)
        var company: Company = this.findByIdOrThrow(companyId)
        company.name = companyRequest.name
        company.phone = companyRequest.phone
        company.users = users

        company = companyRepository.save(company)
        return prepareResponse(company)
    }

    override fun delete(companyId: Long) {
        val company: Company = this.findByIdOrThrow(companyId)
        companyRepository.delete(company)
    }

    override fun findAll(): List<CompanyResponse> {
        val companies: List<Company> = companyRepository.findAll()

        val companyResponses = ArrayList<CompanyResponse>()
        companies.forEach { company -> companyResponses.add(prepareResponse(company)) }
        return companyResponses
    }

    override fun findById(companyId: Long): CompanyResponse {
        val company: Company = this.findByIdOrThrow(companyId)
        return prepareResponse(company)
    }

    override fun findByIdOrThrow(companyId: Long): Company {
        return companyRepository.findById(companyId)
            .orElseThrow {
                NotFoundException(
                    String.format("Company with id: %s not found!", companyId)
                )
            }
    }

    private fun prepareResponse(company: Company): CompanyResponse {
        return CompanyResponse(
            company.id!!, company.name, company.phone,
            company.createdAt!!, company.updatedAt!!, company.users
        )
    }
}
