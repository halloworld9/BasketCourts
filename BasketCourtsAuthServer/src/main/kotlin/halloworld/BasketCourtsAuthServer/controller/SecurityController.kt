package halloworld.BasketCourtsAuthServer.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class SecurityController {

    @GetMapping("/asd")
    fun asd(principal: Principal): String {
        return principal.toString()
    }
}