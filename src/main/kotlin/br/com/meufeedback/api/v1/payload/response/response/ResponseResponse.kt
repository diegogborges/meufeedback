package br.com.meufeedback.api.v1.payload.response.response

import java.time.LocalDateTime

data class ResponseResponse(
    val id: Long,
    val description: String,
    val help: String?,
    val status: Int,
    val sequence: Int,
    val questionId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
