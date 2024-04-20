package br.com.meufeedback.api.v1.payload.customer.response

import java.time.LocalDateTime

data class CustomerResponse(
    val id: Long,
    val name: String,
    val email: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
