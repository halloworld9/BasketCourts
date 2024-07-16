package halloworld.BasketCourtsApp.entity

import halloworld.BasketCourtsApp.entity.enums.SurfaceType
import jakarta.persistence.*
@Entity
open class Court(

    @OneToOne(fetch = FetchType.EAGER)
    open var address: Address,

    @Column
    open var surface: SurfaceType,

    @Column
    open var height: Int = 0,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,
) {


}