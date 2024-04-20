package br.com.meufeedback.repository

import br.com.meufeedback.domain.Assessment
import org.springframework.data.jpa.repository.JpaRepository

interface AssessmentRepository : JpaRepository<Assessment, Long?>
