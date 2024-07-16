package halloworld.BasketCourtsAuthServer.entity

import org.springframework.security.core.GrantedAuthority


enum class Role : GrantedAuthority {
    ANONYMOUS,
    ADMIN,
    USER;

    override fun getAuthority(): String {
        return this.name
    }
}