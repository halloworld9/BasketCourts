package halloworld.Courts.controller

import halloworld.Courts.entity.Address
import halloworld.Courts.entity.Court
import halloworld.Courts.service.CourtService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class CourtController(private val courtService: CourtService) {


    @GetMapping("/court/{city}")
    fun getCityCourts(@PathVariable city: String): Set<Court> {
        return courtService.getCourtsByCity(city)
    }

    @GetMapping("/court", params = ["city", "street", "number"])
    fun getCourt(@Valid @RequestBody address: Address): Court {
        return courtService.getCourtByAddress(address)
    }

    @PostMapping("/court")
    fun saveCourt(@Valid @RequestBody court: Court, @AuthenticationPrincipal principal: Jwt?) {
        if (principal == null || principal.getClaimAsString("role") != "admin")
            throw ResponseStatusException(HttpStatus.FORBIDDEN)
        courtService.saveCourt(court)
        throw ResponseStatusException(HttpStatus.CREATED)
    }

    @DeleteMapping("/court")
    fun deleteCourt(id: Long, @AuthenticationPrincipal principal: Jwt?): Int {
        if (principal == null || principal.getClaimAsString("role") != "admin")
            throw ResponseStatusException(HttpStatus.FORBIDDEN)
        return courtService.deleteCourtById(id)
    }
}
