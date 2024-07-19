package halloworld.BasketCourtsApp.entity

import jakarta.persistence.*

@Entity
class CourtName(

    @Column(name = "court_name", nullable = false)
     var courtName: String,

    @ManyToOne(fetch = FetchType.LAZY)
     var court: Court,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
     var id: Long? = null
) {
}