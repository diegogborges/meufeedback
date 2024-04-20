package br.com.meufeedback.repository

import br.com.meufeedback.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long?>
