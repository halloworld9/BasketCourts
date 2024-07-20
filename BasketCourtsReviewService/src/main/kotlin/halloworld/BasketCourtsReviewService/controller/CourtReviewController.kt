package halloworld.BasketCourtsReviewService.controller

import halloworld.BasketCourtsReviewService.entity.CourtReview
import halloworld.BasketCourtsReviewService.service.CourtReviewService
import jakarta.validation.Valid
import org.springframework.validation.BindingResult
import org.springframework.validation.Validator
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CourtReviewController(
    private val courtReviewService: CourtReviewService
) {

    @GetMapping("/user-reviews")
    fun getUserReviews(userId: Long): List<CourtReview> {
        return courtReviewService.getUserReviews(userId)
    }

    @GetMapping("/court-reviews")
    fun getCourtReviews(courtId: Long): List<CourtReview> {
        return courtReviewService.getCourtsReviews(courtId)
    }

    @PostMapping("/court-review")
    fun addCourtReview(@Valid @RequestBody courtReview: CourtReview): CourtReview {
        return courtReviewService.addCourtReview(courtReview)
    }

    @PutMapping("/court-review")
    fun updateCourtReview(@Valid @RequestBody courtReview: CourtReview): CourtReview {
        return courtReviewService.updateCourtReview(courtReview)
    }

    @DeleteMapping("/remove-court-review", params = ["userId", "courtId"])
    fun removeCourtReview(userId: Long, courtId: Long): Int {
        return courtReviewService.removeCourtReviewByUserIdAndCourtId(userId, courtId)
    }

    @DeleteMapping("/remove-court-review", params = ["id"])
    fun removeCourtReview(id: Long): Int {
        return courtReviewService.removeCourtReviewById(id)
    }

}