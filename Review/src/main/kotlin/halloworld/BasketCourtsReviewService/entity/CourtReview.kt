package halloworld.BasketCourtsReviewService.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Null

@Entity
@Table(name = "court_review", uniqueConstraints = [UniqueConstraint(columnNames = ["user_id", "court_id"])])
class CourtReview(
    @Column(name = "user_id", nullable = false)
    @Null
    var userId: Long? = null,

    @Column(name = "court_id", nullable = false)
    var courtId: Long,

    @Column(nullable = false)
    @field:Min(1, message = "rating can't be less than 1")
    @field:Max(5, message = "rating can't be greater than 5")
    var surface: Byte,

    @Column(nullable = false)
    @field:Min(1, message = "rating can't be less than 1")
    @field:Max(5, message = "rating can't be greater than 5")
    var hoop: Byte,

    @Column(name = "overall_impression", nullable = false)
    @field:Min(1, message = "rating can't be less than 1")
    @field:Max(5, message = "rating can't be greater than 5")
    var overallImpression: Byte,

    @Column
    var review: String = "",

    @Id
    @field:Null(message = "You can't set id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
) {

}