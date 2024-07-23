package halloworld.Courts.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Null

@Entity
@Table(name = "address", uniqueConstraints = [UniqueConstraint(columnNames = ["city", "street", "number"])])
 class Address(
    @Column(nullable = false)
    @field:NotBlank(message = "City cannot be blank")
     var city: String,

    @Column(nullable = false)
    @field:NotBlank(message = "Street cannot be blank")
     var street: String,

    @Column
    @field:NotBlank(message = "Number cannot be blank")
     var number: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "You can't set address id")
    @Column(name = "id", nullable = false, unique = true)
    var id: Long? = null
)