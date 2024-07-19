package halloworld.BasketCourtsReviewService.controller

import halloworld.BasketCourtsReviewService.entity.CourtReview
import halloworld.BasketCourtsReviewService.service.CourtReviewService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
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
    fun addCourtReview(@RequestBody courtReview: CourtReview): CourtReview {
        return courtReviewService.addCourtReview(courtReview)
    }

    @DeleteMapping("/remove-court-review", params = ["userId", "courtId"])
    fun removeCourtReview(userId: Long, courtId: Long) {
        courtReviewService.removeCourtReviewByUserIdAndCourtId(userId, courtId)
    }

    @DeleteMapping("/remove-court-review", params = ["id"])
    fun removeCourtReview(id: Long) {
        courtReviewService.removeCourtReviewById(id)
    }

}