package halloworld.BasketCourtsReviewService.service

import halloworld.BasketCourtsReviewService.entity.CourtReview
import halloworld.BasketCourtsReviewService.repository.CourtReviewRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class CourtReviewService(
    private val courtReviewRepository : CourtReviewRepository
) {
    fun getCourtReviewByUserIdAndCourtId(userId: Long, courtId: Long) : CourtReview? {
        return courtReviewRepository.getByUserIdAndCourtId(userId, courtId)
    }

    fun getUserReviews(userId: Long) : List<CourtReview> {
        return courtReviewRepository.getUsersReviews(userId)
    }

    fun getCourtsReviews(courtId : Long) : List<CourtReview> {
        return courtReviewRepository.getCourtsReviews(courtId)
    }

    fun addCourtReview(userId: Long, courtId: Long, surface: Int, hoop: Int, overallImpression: Int, review: String = ""): CourtReview {
        val courtReview = CourtReview(userId, courtId, surface, hoop, overallImpression, review)
        return courtReviewRepository.save(courtReview)
    }

    fun addCourtReview(courtReview: CourtReview): CourtReview {
        return courtReviewRepository.save(courtReview)
    }

    fun updateCourtReview(userId: Long, courtId: Long, surface: Int, hoop: Int, overallImpression: Int, review: String?) {
        val courtReview = courtReviewRepository.getByUserIdAndCourtId(userId, courtId) ?: throw IllegalArgumentException("You can't update non-existent review")
        updateReviewObject(courtReview, surface, hoop, overallImpression, review)
        courtReviewRepository.updateCourtReview(courtReview.surface, courtReview.hoop, courtReview.overallImpression, courtReview.review, courtReview.id!!)
    }

    fun updateCourtReview(id: Long, surface: Int, hoop: Int, overallImpression: Int, review: String?) {
        val courtReview = courtReviewRepository.findById(id).getOrElse { throw IllegalArgumentException("You can't update non-existent review") }
        updateReviewObject(courtReview, surface, hoop, overallImpression, review)
        courtReviewRepository.updateCourtReview(courtReview.surface, courtReview.hoop, courtReview.overallImpression, courtReview.review, courtReview.id!!)
    }

    private fun updateReviewObject(courtReview: CourtReview, surface: Int?, hoop: Int?, overallImpression: Int?, review: String?) {
        if (surface != null)
            courtReview.surface = surface

        if (hoop != null)
            courtReview.hoop = hoop

        if (overallImpression != null)
            courtReview.overallImpression = overallImpression

        if (review != null)
            courtReview.review = review
    }

    fun removeCourtReviewByUserIdAndCourtId(userId: Long, courtId: Long) {
        courtReviewRepository.removeByUserIdAndCourtId(userId, courtId)
    }

    fun removeCourtReviewById(id: Long) {
        courtReviewRepository.removeById(id)
    }
}