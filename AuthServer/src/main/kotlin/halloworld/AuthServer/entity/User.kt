package halloworld.AuthServer.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.util.*

@Entity
@Table(name = "users")
class User (
    @Column(unique = true)
    @field:Email
    var email: String,

    @Column(unique = true)
    @field:NotBlank
    var username: String,

    @Column
    @field:Size(min = 5, max = 255)
    var password: String,

    @Column(updatable = false, name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    var registerDate: Date,

    @Column
    var role: Role = Role.USER,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null


) {
    override fun toString(): String {
        return "User(email='$email', username='$username', password='$password', registerDate=$registerDate, role=$role, id=$id)"
    }
}