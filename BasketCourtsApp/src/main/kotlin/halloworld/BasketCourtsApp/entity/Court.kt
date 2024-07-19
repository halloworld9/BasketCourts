package halloworld.BasketCourtsApp.entity

import halloworld.BasketCourtsApp.entity.enums.SurfaceType
import jakarta.persistence.*
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

@Entity
class Court(

    @OneToOne(fetch = FetchType.EAGER)
    var address: Address,

    @Column(nullable = false)
    var surface: SurfaceType,

    @Column
    @Min(0)
    @Max(350)
     var height: Int = 0,

    @Column(name = "count_rims")
     var countRims: Int = 0,

    @OneToMany(fetch = FetchType.EAGER)
     var names: Set<CourtName> = emptySet(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
     var id: Long? = null,
) {


}