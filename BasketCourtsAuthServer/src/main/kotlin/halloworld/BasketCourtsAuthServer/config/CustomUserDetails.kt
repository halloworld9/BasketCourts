package halloworld.BasketCourtsAuthServer.config

import halloworld.BasketCourtsAuthServer.entity.Role
import halloworld.BasketCourtsAuthServer.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

class CustomUserDetails(private val user: User) : UserDetails {


    override fun getAuthorities(): Set<Role> {
        return setOf(user.role)
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.username
    }
}