package halloworld.BasketCourtsReviewService.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["user_id", "court_id"])])
class CourtReview(
    @Column(name = "user_id", nullable = false)
    var userId: Long,

    @Column(name = "court_id", nullable = false)
    var courtId: Long,

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    var surface: Int,

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    var hoop: Int,

    @Column(name = "overall_impression", nullable = false)
    @Min(1)
    @Max(5)
    var overallImpression: Int,

    @Column
    var review: String = "",

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
)