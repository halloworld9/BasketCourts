package halloworld.BasketCourtsAuthServer.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
class User (
    @Column(unique = true)
    var email: String,

    @Column(unique = true)
    var username: String,

    @Column
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