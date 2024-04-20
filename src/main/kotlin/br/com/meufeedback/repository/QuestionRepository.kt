package br.com.meufeedback.repository

import br.com.meufeedback.domain.Feedback
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Feedback, Long?>
