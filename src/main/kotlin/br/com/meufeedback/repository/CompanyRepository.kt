package br.com.meufeedback.repository

import br.com.meufeedback.domain.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository : JpaRepository<Company, Long?>
