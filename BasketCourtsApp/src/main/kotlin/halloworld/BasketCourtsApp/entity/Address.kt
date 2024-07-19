package halloworld.BasketCourtsApp.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["city", "street", "number"])])
 class Address(
    @Column(nullable = false)
    @NotBlank
     var city: String,

    @Column(nullable = false)
    @NotBlank
     var street: String,

    @Column
     var number: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
     var id: Long? = null
)