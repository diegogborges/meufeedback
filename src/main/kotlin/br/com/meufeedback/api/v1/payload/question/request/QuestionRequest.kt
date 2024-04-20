package br.com.meufeedback.api.v1.payload.question.request

data class QuestionRequest(
    val description: String,
    val help: String?,
    val status: Int,
    val sequence: Int,
    val openResponse: Int = 0,
)
