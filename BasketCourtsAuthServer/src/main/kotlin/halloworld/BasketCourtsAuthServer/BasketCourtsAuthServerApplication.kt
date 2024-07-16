package halloworld.BasketCourtsAuthServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.authentication.dao.DaoAuthenticationProvider

@SpringBootApplication
class BasketCourtsAuthServerApplication

fun main(args: Array<String>) {
	runApplication<BasketCourtsAuthServerApplication>(*args)
}