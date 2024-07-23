package halloworld.AuthServer.config

import halloworld.AuthServer.entity.Role
import halloworld.AuthServer.entity.User
import halloworld.AuthServer.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*
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