package br.com.meufeedback.api.v1.payload.user.request

data class UserRequest(
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val password: String
)
