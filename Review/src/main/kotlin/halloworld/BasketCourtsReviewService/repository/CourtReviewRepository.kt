package halloworld.BasketCourtsReviewService.repository;

import halloworld.BasketCourtsReviewService.entity.CourtReview
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CourtReviewRepository : JpaRepository<CourtReview, Long> {



    @Query("""
        select c from CourtReview c 
        where  c.userId = :userId and c.courtId = :courtId
        """)
    fun getByUserIdAndCourtId(userId: Long, courtId: Long): CourtReview?

    @Query("""
        select c 
        from CourtReview c 
        where c.courtId = :courtId
        """)
    fun getCourtsReviews(courtId: Long): List<CourtReview>

    @Query("""
        select c 
        from CourtReview c 
        where c.userId = :userId
        """)
    fun getUsersReviews(userId: Long): List<CourtReview>

    @Modifying
    @Query("""
        delete from CourtReview c 
        where c.userId = :userId and c.courtId = :courtId
        """)
    fun removeByUserIdAndCourtId(userId: Long, courtId: Long): Int


    @Modifying
    @Query("""
        delete from CourtReview c 
        where c.id = :id
        """)
    fun removeById(id: Long): Int


    @Modifying
    @Query(
        """update CourtReview c set c.surface = :surface, c.hoop = :hoop, c.overallImpression = :overallImpression, c.review = :review
    where c.userId = :userId and c.courtId = :courtId"""
    )
    fun updateCourtReviewByUserIdAndCourtId(
        surface: Byte,
        hoop: Byte,
        overallImpression: Byte,
        review: String,
        userId: Long,
        courtId: Long
    ) : Int
}