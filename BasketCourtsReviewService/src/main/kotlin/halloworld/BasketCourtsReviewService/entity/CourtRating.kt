package halloworld.BasketCourtsReviewService.entity

import jakarta.persistence.*

@Entity
class CourtRating(

    @Column
    var courtId: Long,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
)