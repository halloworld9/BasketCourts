package halloworld.AuthServer.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
@Table(name = "users")
class User (
    @Column(unique = true)
    @field:Email
    var email: String,

    @Column(unique = true)
    @field:NotBlank
    var name: String,

    @Column
    @field:Size(min = 5, max = 255)
    private var password: String,

    @Column(updatable = false, name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    var registerDate: Date,

    @Column
    var role: Role = Role.USER,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null


) : UserDetails {
    override fun getAuthorities(): Set<Role> {
        return setOf(role)
    }

    override fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    override fun getUsername(): String {
        return email
    }
}