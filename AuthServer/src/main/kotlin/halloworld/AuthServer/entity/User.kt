package halloworld.AuthServer.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnTransformer
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
@Table(name = "users")
open class User (
    @Column(unique = true)
    @field:Email
    open var email: String,

    @Column(unique = true)
    @field:NotBlank
    open var name: String,

    @Column
    @field:Size(min = 5, max = 255)
    private var password: String,

    @Column(updatable = false, name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    open var registerDate: Date,

    @Column(nullable = false)
    open var role: Role,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null


) : UserDetails {
    open override fun getAuthorities(): Set<Role> {
        return setOf(role)
    }

    open override fun getPassword(): String {
        return password
    }

    open fun setPassword(password: String) {
        this.password = password
    }

    open override fun getUsername(): String {
        return email
    }
}