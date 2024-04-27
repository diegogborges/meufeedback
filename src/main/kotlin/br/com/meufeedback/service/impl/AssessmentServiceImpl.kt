package br.com.meufeedback.service.impl

import br.com.meufeedback.api.v1.payload.assessment.request.AssessmentRequest
import br.com.meufeedback.api.v1.payload.assessment.response.AssessmentResponse
import br.com.meufeedback.domain.Assessment
import br.com.meufeedback.domain.StatusEnum
import br.com.meufeedback.exception.NotFoundException
import br.com.meufeedback.repository.AssessmentRepository
import br.com.meufeedback.service.CompanyService
import br.com.meufeedback.service.AssessmentService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AssessmentServiceImpl(
    private val assessmentRepository: AssessmentRepository,
    private val companyService: CompanyService
) : AssessmentService {

    override fun save(assessmentRequest: AssessmentRequest): AssessmentResponse {
        var assessment = Assessment(
            feedback = assessmentRequest.feedbackId,
            customer = assessmentRequest.customerId,
git            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        assessment = assessmentRepository.save(assessment)
        return prepareResponse(assessment)
    }

    override fun update(assessmentRequest: AssessmentRequest, assessmentId: Long): AssessmentResponse {
        var assessment: Assessment = this.findByIdOrThrow(assessmentId)
        assessment = Assessment(
            name = assessmentRequest.name,
            description = assessmentRequest.description,
            slug = assessmentRequest.slug,
            status = StatusEnum.find(assessmentRequest.status),
            company = companyService.findByIdOrThrow(assessmentRequest.companyId),
            createdAt = assessment.createdAt,
            updatedAt = LocalDateTime.now()
        )

        assessment = assessmentRepository.save(assessment)
        return prepareResponse(assessment)
    }

    override fun delete(assessmentId: Long) {
        val assessment: Assessment = this.findByIdOrThrow(assessmentId)
        assessmentRepository.delete(assessment)
    }

    override fun findAll(): List<AssessmentResponse> {
        val companies: List<Assessment> = assessmentRepository.findAll()

        val assessmentResponses = ArrayList<AssessmentResponse>()
        companies.forEach { assessment -> assessmentResponses.add(prepareResponse(assessment)) }
        return assessmentResponses
    }

    override fun findById(assessmentId: Long): AssessmentResponse {
        val assessment: Assessment = this.findByIdOrThrow(assessmentId)
        return prepareResponse(assessment)
    }

    override fun findByIdOrThrow(assessmentId: Long): Assessment {
        return assessmentRepository.findById(assessmentId)
            .orElseThrow {
                NotFoundException(
                    String.format("Assessment with id: %s not found!", assessmentId)
                )
            }
    }

    private fun prepareResponse(assessment: Assessment): AssessmentResponse {
        return AssessmentResponse(
            assessment.id!!, assessment.name, assessment.description, assessment.slug,
            assessment.status.status, assessment.company.id!!, assessment.createdAt!!, assessment.updatedAt!!
        )
    }
}
