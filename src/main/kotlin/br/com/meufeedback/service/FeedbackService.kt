package br.com.meufeedback.service

import br.com.meufeedback.api.v1.payload.feedback.request.FeedbackRequest
import br.com.meufeedback.api.v1.payload.feedback.response.FeedbackResponse
import br.com.meufeedback.domain.Feedback

interface FeedbackService {

    fun save(feedbackRequest: FeedbackRequest): FeedbackResponse

    fun update(feedbackRequest: FeedbackRequest, feedbackId: Long): FeedbackResponse

    fun delete(feedbackId: Long)

    fun findAll(): List<FeedbackResponse>

    fun findById(feedbackId: Long): FeedbackResponse

    fun findByIdOrThrow(feedbackId: Long): Feedback
}
