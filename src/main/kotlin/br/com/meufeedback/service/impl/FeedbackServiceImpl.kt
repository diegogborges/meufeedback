package br.com.meufeedback.service.impl

import br.com.meufeedback.api.v1.payload.feedback.request.FeedbackRequest
import br.com.meufeedback.api.v1.payload.feedback.response.FeedbackResponse
import br.com.meufeedback.domain.Feedback
import br.com.meufeedback.domain.StatusEnum
import br.com.meufeedback.exception.NotFoundException
import br.com.meufeedback.repository.FeedbackRepository
import br.com.meufeedback.service.CompanyService
import br.com.meufeedback.service.FeedbackService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FeedbackServiceImpl(
    private val feedbackRepository: FeedbackRepository,
    private val companyService: CompanyService
) : FeedbackService {

    override fun save(feedbackRequest: FeedbackRequest): FeedbackResponse {
        var feedback = Feedback(
            name = feedbackRequest.name,
            description = feedbackRequest.description,
            slug = feedbackRequest.slug,
            status = StatusEnum.find(feedbackRequest.status),
            company = companyService.findByIdOrThrow(feedbackRequest.companyId),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        feedback = feedbackRepository.save(feedback)
        return prepareResponse(feedback)
    }

    override fun update(feedbackRequest: FeedbackRequest, feedbackId: Long): FeedbackResponse {
        var feedback: Feedback = this.findByIdOrThrow(feedbackId)
        feedback = Feedback(
            name = feedbackRequest.name,
            description = feedbackRequest.description,
            slug = feedbackRequest.slug,
            status = StatusEnum.find(feedbackRequest.status),
            company = companyService.findByIdOrThrow(feedbackRequest.companyId),
            createdAt = feedback.createdAt,
            updatedAt = LocalDateTime.now()
        )

        feedback = feedbackRepository.save(feedback)
        return prepareResponse(feedback)
    }

    override fun delete(feedbackId: Long) {
        val feedback: Feedback = this.findByIdOrThrow(feedbackId)
        feedbackRepository.delete(feedback)
    }

    override fun findAll(): List<FeedbackResponse> {
        val companies: List<Feedback> = feedbackRepository.findAll()

        val feedbackResponses = ArrayList<FeedbackResponse>()
        companies.forEach { feedback -> feedbackResponses.add(prepareResponse(feedback)) }
        return feedbackResponses
    }

    override fun findById(feedbackId: Long): FeedbackResponse {
        val feedback: Feedback = this.findByIdOrThrow(feedbackId)
        return prepareResponse(feedback)
    }

    override fun findByIdOrThrow(feedbackId: Long): Feedback {
        return feedbackRepository.findById(feedbackId)
            .orElseThrow {
                NotFoundException(
                    String.format("Feedback with id: %s not found!", feedbackId)
                )
            }
    }

    private fun prepareResponse(feedback: Feedback): FeedbackResponse {
        return FeedbackResponse(
            feedback.id!!, feedback.name, feedback.description, feedback.slug,
            feedback.status.status, feedback.company.id!!, feedback.createdAt!!, feedback.updatedAt!!
        )
    }
}
