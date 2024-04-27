package br.com.meufeedback.service

import br.com.meufeedback.api.v1.payload.assessment.request.AssessmentRequest
import br.com.meufeedback.api.v1.payload.assessment.response.AssessmentResponse
import br.com.meufeedback.domain.Assessment

interface AssessmentService {

    fun save(assessmentRequest: AssessmentRequest): AssessmentResponse

    fun update(assessmentRequest: AssessmentRequest, assessmentId: Long): AssessmentResponse

    fun delete(assessmentId: Long)

    fun findAll(): List<AssessmentResponse>

    fun findById(assessmentId: Long): AssessmentResponse

    fun findByIdOrThrow(assessmentId: Long): Assessment
}
