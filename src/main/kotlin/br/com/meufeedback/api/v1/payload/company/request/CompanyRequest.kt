package br.com.meufeedback.api.v1.payload.company.request

import jakarta.persistence.*
import lombok.Builder
import lombok.Data
import java.time.LocalDateTime

data class CompanyRequest (
    val name: String,
    val phone: String,
    val users: List<Long>
)
