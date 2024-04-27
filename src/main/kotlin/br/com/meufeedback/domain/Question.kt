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
@Table(name = "question")
data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val description: String,
    val help: String?,
    val status: StatusEnum,
    val sequence: Int,
    val openResponse: Int = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    val feedback: Feedback,
    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: LocalDateTime?,
    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: LocalDateTime?,
)
