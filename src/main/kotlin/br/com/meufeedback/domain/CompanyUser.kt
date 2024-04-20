package br.com.meufeedback.domain

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(
    name = "company_user"
    /*   uniqueConstraints =
       arrayOf(UniqueConstraint(name = "UK_MESSAGE_TYPE_DESCRIPTION", columnNames = "description"))*/
)
data class CompanyUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "company_id", nullable = false,
        foreignKey = ForeignKey(name = "FK_COMPANY")
    )
    val company: Company,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_USER")
    )
    val user: User,

    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: LocalDateTime,
    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: LocalDateTime,
)