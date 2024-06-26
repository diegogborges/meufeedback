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
@Table(name = "company")
data class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var name: String,
    var phone: String,
    @OneToMany
    var users: List<User>,
    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: LocalDateTime?,
    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: LocalDateTime?
)
