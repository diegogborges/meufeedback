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
@Table(name = "marked_response")
data class MarkedResponse(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null,
    val openResponse: String,
    @ManyToOne(fetch = FetchType.LAZY)
    val question: Question,
    @ManyToOne(fetch = FetchType.LAZY)
    val assessment: Assessment,
    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: LocalDateTime?,
    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: LocalDateTime?,
)
