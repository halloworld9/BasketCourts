package halloworld.BasketCourtsServiceRegister

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer
class BasketCourtsServiceRegisterApplication

fun main(args: Array<String>) {
	runApplication<BasketCourtsServiceRegisterApplication>(*args)
}
