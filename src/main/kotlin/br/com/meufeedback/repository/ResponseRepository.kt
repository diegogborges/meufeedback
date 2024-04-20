package br.com.meufeedback.repository

import br.com.meufeedback.domain.Response
import org.springframework.data.jpa.repository.JpaRepository

interface ResponseRepository : JpaRepository<Response, Long?>
