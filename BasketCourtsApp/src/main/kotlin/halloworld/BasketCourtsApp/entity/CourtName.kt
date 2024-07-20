package halloworld.BasketCourtsApp.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Null

@Entity
class CourtName(

    @Column(name = "court_name", nullable = false)
    @NotBlank(message = "Name cannot be blank")
    var courtName: String,

    @ManyToOne(fetch = FetchType.LAZY)
    var court: Court,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "You can't set court name id")
    @Column(name = "id", nullable = false, unique = true)
     var id: Long? = null
) {
}