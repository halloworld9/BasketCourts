package halloworld.AuthServer.entity

import org.springframework.security.core.GrantedAuthority


enum class Role : GrantedAuthority {
    ADMIN,
    USER;

    override fun getAuthority(): String {
        return this.name
    }
}