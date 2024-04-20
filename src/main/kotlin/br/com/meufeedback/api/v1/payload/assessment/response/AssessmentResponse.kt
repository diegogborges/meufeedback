package br.com.meufeedback.api.v1.payload.assessment.response

import jakarta.persistence.*
import lombok.Builder
import lombok.Data
import java.time.LocalDateTime

data class AssessmentResponse(
    val id: Long,
    val feedbackId: Long,
    val clientId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
