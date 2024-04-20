package br.com.meufeedback.api.v1.payload.question.response

import java.time.LocalDateTime

data class QuestionResponse(
    val id: Long,
    val description: String,
    val help: String?,
    val status: Int,
    val sequence: Int,
    val openResponse: Int = 0,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
