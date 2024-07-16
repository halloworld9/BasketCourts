package halloworld.BasketCourtsReviewService;

import halloworld.BasketCourtsReviewService.entity.CourtRating
import org.springframework.data.jpa.repository.JpaRepository

interface CourtRatingRepository : JpaRepository<CourtRating, Long> {

}