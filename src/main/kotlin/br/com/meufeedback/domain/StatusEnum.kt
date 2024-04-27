package br.com.meufeedback.domain

import java.util.*


enum class StatusEnum(val status: Int, val description: String) {
    ACTIVATED(1, "Ativo"),
    DISABLED(0, "Desativado");

    companion object {
        fun find(status: Int): StatusEnum {
            return Arrays.stream(entries.toTypedArray())
                .filter { s -> s.status == status }.findFirst()
                .orElseThrow { IllegalArgumentException(status.toString()) }
        }
    }
}
