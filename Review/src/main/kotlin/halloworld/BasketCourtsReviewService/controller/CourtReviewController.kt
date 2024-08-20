package halloworld.BasketCourtsReviewService.controller

import halloworld.BasketCourtsReviewService.entity.CourtReview
import halloworld.BasketCourtsReviewService.service.CourtReviewService
import jakarta.validation.Valid
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.*

@RestController
class CourtReviewController(
    private val courtReviewService: CourtReviewService
) {

    @GetMapping("/court", params = ["userId"])
    fun getUserReviews(@RequestBody userId: Long): List<CourtReview> {
        return courtReviewService.getUserReviews(userId)
    }

    @GetMapping("/court", params = ["courtId"])
    fun getCourtReviews(@RequestBody courtId: Long): List<CourtReview> {
        return courtReviewService.getCourtsReviews(courtId)
    }

    @PostMapping("/court")
    fun addCourtReview(@Valid @RequestBody courtReview: CourtReview, @AuthenticationPrincipal principal: Jwt): CourtReview {
        courtReview.userId = principal.claims["id"] as Long
        return courtReviewService.addCourtReview(courtReview)
    }

    @PutMapping("/court")
    fun updateCourtReview(@Valid @RequestBody courtReview: CourtReview, @AuthenticationPrincipal principal: Jwt): CourtReview {
        courtReview.userId = principal.claims["id"] as Long
        return courtReviewService.updateCourtReview(courtReview)
    }

    @DeleteMapping("/court", params = ["userId", "courtId"])
    fun removeCourtReview(@RequestBody courtId: Long, @AuthenticationPrincipal principal: Jwt): Int {
        val userId = principal.claims["id"] as Long
        return courtReviewService.removeCourtReviewByUserIdAndCourtId(userId, courtId)
    }
}