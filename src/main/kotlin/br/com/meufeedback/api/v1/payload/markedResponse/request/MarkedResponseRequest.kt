package br.com.meufeedback.api.v1.payload.markedResponse.request

data class MarkedResponseRequest(
    val openResponse: String,
    val questionId: Long,
    val assessmentId: Long,
)
