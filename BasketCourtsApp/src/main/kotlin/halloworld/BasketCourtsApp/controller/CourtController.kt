package halloworld.BasketCourtsApp.controller

import halloworld.BasketCourtsApp.entity.Court
import halloworld.BasketCourtsApp.service.CourtService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CourtController(private val courtService: CourtService) {

    @GetMapping("/{city}")
    fun getCityCourts(@PathVariable city: String): Set<Court> {
        return courtService.getCourtsByCity(city)
    }

    @GetMapping("/{city}", params = ["city", "street", "number"])
    fun getCourt(@PathVariable city: String, street: String, number: String): Court {
        return courtService.getCourtByAddress(city, street, number)
    }

    @PostMapping("/court")
    fun saveCourt(city: String, street: String, number: String,
                    surface: String, height: Int = 0): Court {
        return courtService.saveCourt(city, street, number, surface, height)
    }

}
