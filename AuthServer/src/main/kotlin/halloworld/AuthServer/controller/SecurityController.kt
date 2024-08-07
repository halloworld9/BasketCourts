package halloworld.AuthServer.controller


import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.userdetails.User
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class SecurityController {

    @GetMapping("/asd")
    fun asd(jwt: Jwt): String {
        return jwt.claims.toString()
    }
}