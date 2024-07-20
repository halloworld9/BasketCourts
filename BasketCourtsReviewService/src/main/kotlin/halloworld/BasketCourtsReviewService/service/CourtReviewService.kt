package halloworld.BasketCourtsReviewService.service

import halloworld.BasketCourtsReviewService.entity.CourtReview
import halloworld.BasketCourtsReviewService.repository.CourtReviewRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.Validator
import kotlin.jvm.optionals.getOrElse

@Service
class CourtReviewService(
    private val courtReviewRepository: CourtReviewRepository
) {
    fun getCourtReviewByUserIdAndCourtId(userId: Long, courtId: Long): CourtReview? {
        return courtReviewRepository.getByUserIdAndCourtId(userId, courtId)
    }

    fun getUserReviews(userId: Long): List<CourtReview> {
        return courtReviewRepository.getUsersReviews(userId)
    }

    fun getCourtsReviews(courtId: Long): List<CourtReview> {
        return courtReviewRepository.getCourtsReviews(courtId)
    }

    @Transactional
    fun addCourtReview(courtReview: CourtReview): CourtReview {
        return courtReviewRepository.save(courtReview)
    }

    @Transactional
    fun updateCourtReview(courtReview: CourtReview): CourtReview {
        return courtReview.apply {
            courtReviewRepository.updateCourtReviewByUserIdAndCourtId(
                surface,
                hoop,
                overallImpression,
                review,
                userId,
                courtId
            )
        }
    }

    @Transactional
    fun removeCourtReviewByUserIdAndCourtId(userId: Long, courtId: Long): Int {
        return courtReviewRepository.removeByUserIdAndCourtId(userId, courtId)
    }

    @Transactional
    fun removeCourtReviewById(id: Long): Int {
        return courtReviewRepository.removeById(id)
    }
}