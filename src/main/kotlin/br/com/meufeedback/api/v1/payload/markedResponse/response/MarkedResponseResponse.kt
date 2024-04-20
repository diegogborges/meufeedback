package br.com.meufeedback.api.v1.payload.markedResponse.response

import java.time.LocalDateTime

data class MarkedResponseResponse(
    val id: Int,
    val openResponse: String,
    val questionId: Long,
    val assessmentId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
