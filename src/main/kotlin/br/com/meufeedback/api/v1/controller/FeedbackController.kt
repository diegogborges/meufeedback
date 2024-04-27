package br.com.meufeedback.api.v1.controller

import br.com.meufeedback.api.v1.payload.feedback.request.FeedbackRequest
import br.com.meufeedback.api.v1.payload.feedback.response.FeedbackResponse
import br.com.meufeedback.service.FeedbackService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("feedbacks")
class FeedbackController(private val feedbackService: FeedbackService) {

    @GetMapping
    fun getCompanies(): List<FeedbackResponse> {
        return feedbackService.findAll()
    }

    @GetMapping("/{feedbackId}")
    fun getFeedbackById(
        @PathVariable feedbackId: Long
    ): ResponseEntity<FeedbackResponse> {
        val feedbackResponse: FeedbackResponse = feedbackService.findById(feedbackId)
        return ResponseEntity<FeedbackResponse>(feedbackResponse, null, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody feedbackRequest: FeedbackRequest): ResponseEntity<FeedbackResponse> {
        val feedbackResponse
                : FeedbackResponse = feedbackService.save(feedbackRequest)

        return ResponseEntity<FeedbackResponse>(feedbackResponse, null, HttpStatus.CREATED)
    }

    @PutMapping("/{feedbackId}")
    fun update(
        @RequestBody feedbackRequest: FeedbackRequest,
        @PathVariable feedbackId: Long
    ): ResponseEntity<FeedbackResponse> {
        val feedbackResponse
                : FeedbackResponse = feedbackService.update(feedbackRequest, feedbackId)

        return ResponseEntity<FeedbackResponse>(feedbackResponse, null, HttpStatus.CREATED)
    }

    @DeleteMapping("/{feedbackId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable feedbackId: Long) {
        feedbackService.delete(feedbackId)
    }
}
