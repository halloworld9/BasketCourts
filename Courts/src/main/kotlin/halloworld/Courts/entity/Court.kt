package halloworld.Courts.entity

import halloworld.Courts.entity.enums.SurfaceType
import jakarta.persistence.*
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Null

@Entity
@Table(name = "court")
class Court(

    @OneToOne(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST, CascadeType.REMOVE])
    var address: Address,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var surface: SurfaceType,

    @Column
    @Min(0, message = "Height can't be negative")
    @Max(350, message = "Height can't higher 350")
    var height: Short = 0,

    @Column(name = "count_rims")
    @Min(0, message = "Can't be negative count of rims")
    var countRims: Short = 0,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Null(message = "You can't set court id")
    var id: Long? = null,
) {


}