package halloworld.BasketCourtsServerAdmin

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer
class BasketCourtsServerAdmin

fun main(args: Array<String>) {
	runApplication<BasketCourtsServerAdmin>(*args)
}
