package br.com.meuassessment.api.v1.controller

import br.com.meuassessment.api.v1.payload.assessment.request.AssessmentRequest
import br.com.meuassessment.api.v1.payload.assessment.response.AssessmentResponse
import br.com.meuassessment.service.AssessmentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("assessments")
class AssessmentController(private val assessmentService: AssessmentService) {

    @GetMapping
    fun getCompanies(): List<AssessmentResponse> {
        return assessmentService.findAll()
    }

    @GetMapping("/{assessmentId}")
    fun getAssessmentById(
        @PathVariable assessmentId: Long
    ): ResponseEntity<AssessmentResponse> {
        val assessmentResponse: AssessmentResponse = assessmentService.findById(assessmentId)
        return ResponseEntity<AssessmentResponse>(assessmentResponse, null, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody assessmentRequest: AssessmentRequest): ResponseEntity<AssessmentResponse> {
        val assessmentResponse
                : AssessmentResponse = assessmentService.save(assessmentRequest)

        return ResponseEntity<AssessmentResponse>(assessmentResponse, null, HttpStatus.CREATED)
    }

    @PutMapping("/{assessmentId}")
    fun update(
        @RequestBody assessmentRequest: AssessmentRequest,
        @PathVariable assessmentId: Long
    ): ResponseEntity<AssessmentResponse> {
        val assessmentResponse
                : AssessmentResponse = assessmentService.update(assessmentRequest, assessmentId)

        return ResponseEntity<AssessmentResponse>(assessmentResponse, null, HttpStatus.CREATED)
    }

    @DeleteMapping("/{assessmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable assessmentId: Long) {
        assessmentService.delete(assessmentId)
    }
}
