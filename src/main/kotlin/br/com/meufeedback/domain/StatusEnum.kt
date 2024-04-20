package br.com.meufeedback.domain

enum class StatusEnum(val status: Int, val description: String) {
    ACTIVATED(1, "Ativo"),
    DISABLED(1, "Desativado")
}
