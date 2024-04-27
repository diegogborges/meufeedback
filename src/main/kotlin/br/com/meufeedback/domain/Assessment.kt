package br.com.meufeedback.domain

import jakarta.persistence.*
import lombok.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assessment")
data class Assessment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null,
    @ManyToOne(fetch = FetchType.LAZY)
    val feedback: Feedback,
    @ManyToOne(fetch = FetchType.LAZY)
    val customer: Customer,
    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: LocalDateTime?,
    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: LocalDateTime?,
)
