package br.com.meufeedback.service

import br.com.meufeedback.api.v1.payload.company.request.CompanyRequest
import br.com.meufeedback.api.v1.payload.company.response.CompanyResponse
import br.com.meufeedback.domain.Company
import br.com.meufeedback.exception.NotFoundException
import br.com.meufeedback.repository.CompanyRepository
import br.com.meufeedback.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

interface CompanyService {

    fun save(companyRequest: CompanyRequest): CompanyResponse

    fun update(companyRequest: CompanyRequest, companyId: Long): CompanyResponse

    fun delete(companyId: Long)

    fun findAll(): List<CompanyResponse>

    fun findById(companyId: Long): CompanyResponse

    fun findByIdOrThrow(companyId: Long): Company
}
