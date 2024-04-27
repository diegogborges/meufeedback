package br.com.meufeedback.api.v1.payload.feedback.request

data class FeedbackRequest(
    val name: String,
    val description: String,
    val slug: String,
    val status: Int,
    val companyId: Long,
)
