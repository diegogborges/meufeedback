package br.com.meufeedback.domain

import jakarta.persistence.*
import lombok.Builder
import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Builder
@Data
@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    //val groups: List
    //val userPermissions: List
    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: LocalDateTime?,
    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: LocalDateTime?,
)
