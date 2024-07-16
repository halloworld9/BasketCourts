package halloworld.BasketCourtsApp.entity

import jakarta.persistence.*

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["city", "street", "number"])])
open class Address(
    @Column
    open var city: String,
    @Column
    open var street: String,
    @Column
    open var number: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

)