package halloworld.AuthServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthServerAppication

fun main(args: Array<String>) {
    runApplication<AuthServerAppication>(*args)
}