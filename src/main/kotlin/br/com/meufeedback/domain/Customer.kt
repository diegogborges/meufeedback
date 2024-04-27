package br.com.meufeedback.domain

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null,
    val name: String,
    val email: String,
    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: LocalDateTime?,
    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: LocalDateTime?,
)
