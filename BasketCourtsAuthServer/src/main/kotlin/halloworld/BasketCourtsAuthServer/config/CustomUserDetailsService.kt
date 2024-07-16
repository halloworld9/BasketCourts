package halloworld.BasketCourtsAuthServer.config

import halloworld.BasketCourtsAuthServer.entity.Role
import halloworld.BasketCourtsAuthServer.entity.User
import halloworld.BasketCourtsAuthServer.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.Date
import kotlin.jvm.optionals.getOrElse

@Service
class CustomUserDetailsService(private val userService: UserService, encoder: PasswordEncoder) : UserDetailsService {

    init {
        val admin = User("admin", "admin", encoder.encode("123"), Date(), Role.ADMIN)
        val user = User("eshkere", "user", encoder.encode("123"), Date(), Role.USER)
        println(userService.saveUser(admin))
        println(userService.saveUser(user))
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userService.findUserByUsername(username)
            .getOrElse { throw UsernameNotFoundException(username) }
        return CustomUserDetails(user)
    }
}