package br.com.meufeedback.api.v1.payload.assessment.request

data class AssessmentRequest(
    val feedbackId: Long,
    val clientId: Long
)
