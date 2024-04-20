package br.com.meufeedback.repository

import br.com.meufeedback.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long?>
