package br.com.meufeedback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MeufeedbackApplication

fun main(args: Array<String>) {
	runApplication<MeufeedbackApplication>(*args)
}
