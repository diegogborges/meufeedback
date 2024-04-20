package br.com.meufeedback.api.v1.payload.response.request

data class ResponseRequest(
    val description: String,
    val help: String?,
    val status: Int,
    val sequence: Int,
    val questionId: Long,
)
