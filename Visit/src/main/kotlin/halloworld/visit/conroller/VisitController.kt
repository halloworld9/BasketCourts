package halloworld.visit.conroller

import halloworld.visit.entity.Visit
import halloworld.visit.service.VisitService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDate
import java.time.LocalTime

@RestController
class VisitController(private val visitService: VisitService) {

    @GetMapping("/visit/court", params = ["date", "courtId"])
    fun getCourtVisitsOnDay(@RequestParam date: LocalDate, @RequestParam courtId: Long): List<Visit> {
        return visitService.getCourtVisitsOnDay(date, courtId)
    }

    @GetMapping("/visit/court/count", params = ["date", "courtId"])
    fun getCountOfVisitsOnDay(@RequestParam date: LocalDate, @RequestParam courtId: Long): Int {
        return visitService.getCountOfCourtVisitsOnDay(date, courtId)
    }

    @GetMapping("/visit/user", params = ["userId"])
    fun getUserVisits(@RequestParam userId: Long): List<Visit> {
        return visitService.getUserVisits(userId)
    }


    @GetMapping("/visit/user/court", params = ["courtId", "userId"])
    fun getUserCourtVisits(@RequestBody courtId: Long, @RequestBody userId: Long): List<Visit> {
        return visitService.getUserCourtVisits(courtId, userId)
    }

    @DeleteMapping("/visit")
    fun deleteVisit(@RequestBody visitId: Long, @AuthenticationPrincipal principal: Jwt?): Int {
        if (principal == null)
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        val userId = principal.claims["id"] as Long
        return visitService.deleteVisit(visitId, userId)
    }

    @PostMapping("/visit")
    fun addVisit(@RequestBody @Valid visit: Visit, @AuthenticationPrincipal principal: Jwt?) {
        if (principal == null)
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        visit.userId = principal.claims["id"] as Long
        visitService.addVisit(visit)
        throw ResponseStatusException(HttpStatus.CREATED)
    }

    @PutMapping("/visit", params = ["time", "visitId"])
    fun updateVisitTime(@RequestBody time: LocalTime, @RequestBody visitId: Long, @AuthenticationPrincipal principal: Jwt?): Int {
        if (principal == null)
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        val userId = principal.claims["id"] as Long
        return visitService.updateVisitTimeById(time, visitId, userId)
    }
}