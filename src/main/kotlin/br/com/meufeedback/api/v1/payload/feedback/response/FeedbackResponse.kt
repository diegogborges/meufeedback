package br.com.meufeedback.api.v1.payload.feedback.response

import java.time.LocalDateTime

data class FeedbackResponse(
    val id: Long,
    val name: String,
    val description: String,
    val slug: String,
    val status: Int,
    val companyId: Long,
    //val questions: Questions, ManyToManyField
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
