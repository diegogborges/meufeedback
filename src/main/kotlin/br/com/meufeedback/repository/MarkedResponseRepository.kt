package br.com.meufeedback.repository

import br.com.meufeedback.domain.MarkedResponse
import org.springframework.data.jpa.repository.JpaRepository

interface MarkedResponseRepository : JpaRepository<MarkedResponse, Long?>
