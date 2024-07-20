package halloworld.BasketCourtsApp.controller

import halloworld.BasketCourtsApp.entity.Address
import halloworld.BasketCourtsApp.entity.Court
import halloworld.BasketCourtsApp.service.CourtService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
class CourtController(private val courtService: CourtService) {

    @GetMapping("/city")
    fun getCityCourts(city: String): Set<Court> {
        return courtService.getCourtsByCity(city)
    }

    @GetMapping("/court", params = ["city", "street", "number"])
    fun getCourt(@Valid @RequestBody address: Address): Court {
        return courtService.getCourtByAddress(address)
    }

    @PostMapping("/court")
    fun saveCourt(@Valid @RequestBody court: Court): Court {
        return courtService.saveCourt(court)
    }

    @DeleteMapping("/court")
    fun deleteCourt(id: Long): Int {
        return courtService.deleteCourtById(id)
    }

}
