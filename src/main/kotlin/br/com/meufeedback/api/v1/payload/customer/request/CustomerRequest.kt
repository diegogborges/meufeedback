package br.com.meufeedback.api.v1.payload.customer.request

import jakarta.persistence.*
import lombok.Builder
import lombok.Data
import java.time.LocalDateTime

data class CustomerRequest(
    val name: String,
    val email: String,
)
