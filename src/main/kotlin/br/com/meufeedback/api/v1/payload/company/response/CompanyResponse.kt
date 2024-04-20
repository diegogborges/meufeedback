package br.com.meufeedback.api.v1.payload.company.response

import br.com.meufeedback.domain.User
import java.time.LocalDateTime

data class CompanyResponse(
    val id: Long,
    val name: String,
    val phone: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val userId: List<User>
)
