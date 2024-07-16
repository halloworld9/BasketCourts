package halloworld.BasketCourtsApp.controller

import halloworld.BasketCourtsApp.entity.Address
import halloworld.BasketCourtsApp.entity.Court
import halloworld.BasketCourtsApp.repository.AddressRepository
import halloworld.BasketCourtsApp.service.CourtService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CourtController(private val courtService: CourtService) {

    @GetMapping("/city/{city}")
    fun getCityCourts(@PathVariable city: String): Set<Court> {
        return courtService.getCourtsByCity(city)
    }
    @PostMapping("/court")
    fun saveCourt(city: String, street: String, number: String,
                    surface: String, height: Int = 0): Court {
        return courtService.saveCourt(city, street, number, surface, height)
    }

}
