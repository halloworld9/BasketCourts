package halloworld.BasketCourtsReviewService.controller

import halloworld.BasketCourtsReviewService.entity.CourtReview
import halloworld.BasketCourtsReviewService.service.CourtReviewService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class CourtReviewController(
    private val courtReviewService: CourtReviewService
) {

    @GetMapping("/review/user", params = ["userId"])
    fun getUserReviews(@RequestParam userId: Long): List<CourtReview> {
        return courtReviewService.getUserReviews(userId)
    }

    @GetMapping("/review/court", params = ["courtId"])
    fun getCourtReviews(@RequestParam courtId: Long): List<CourtReview> {
        return courtReviewService.getCourtsReviews(courtId)
    }

    @GetMapping("/review/my")
    fun getMyReviews(@AuthenticationPrincipal principal: Jwt?): List<CourtReview> {
        if (principal == null)
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        val id = principal.claims["id"] as Long
        return courtReviewService.getUserReviews(id)
    }

    @PostMapping("/review")
    fun addCourtReview(@Valid @RequestBody courtReview: CourtReview, @AuthenticationPrincipal principal: Jwt?) {
        if (principal == null)
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        courtReview.userId = principal.claims["id"] as Long
        courtReviewService.addCourtReview(courtReview)
        throw ResponseStatusException(HttpStatus.CREATED)
    }

    @PutMapping("/review")
    fun updateCourtReview(@Valid @RequestBody courtReview: CourtReview, @AuthenticationPrincipal principal: Jwt?): Int {
        if (principal == null)
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        courtReview.userId = principal.claims["id"] as Long
        return courtReviewService.updateCourtReview(courtReview)
    }

    @DeleteMapping("/review", params = ["userId", "courtId"])
    fun removeCourtReview(@RequestBody courtId: Long, @AuthenticationPrincipal principal: Jwt?): Int {
        if (principal == null)
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        val userId = principal.claims["id"] as Long
        return courtReviewService.removeCourtReviewByUserIdAndCourtId(userId, courtId)
    }
}