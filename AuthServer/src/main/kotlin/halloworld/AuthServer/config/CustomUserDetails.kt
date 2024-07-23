package halloworld.AuthServer.config

import halloworld.AuthServer.entity.Role
import halloworld.AuthServer.entity.User
import org.springframework.security.core.userdetails.UserDetails

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