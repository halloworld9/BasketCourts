package halloworld.visit.conroller

import halloworld.visit.entity.Visit
import halloworld.visit.service.VisitService
import jakarta.validation.Valid
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalTime

@RestController
class VisitController(private val visitService: VisitService) {

    @GetMapping("/court", params = ["date", "courtId"])
    fun getCourtVisitsOnDay(@RequestBody date: LocalDate, @RequestBody courtId: Long): List<Visit> {
        return visitService.getCourtVisitsOnDay(date, courtId)
    }

    @GetMapping("/court/count")
    fun getCountOfVisitsOnDay(@RequestBody date: LocalDate, @RequestBody courtId: Long): Int {
        return visitService.getCountOfCourtVisitsOnDay(date, courtId)
    }

    @GetMapping("/user")
    fun getUserVisits(@RequestBody userId: Long): List<Visit> {
        return visitService.getUserVisits(userId)
    }

    @GetMapping("/me")
    fun getMyVisits(@AuthenticationPrincipal principal: Jwt): List<Visit> {
        return visitService.getUserVisits(principal.claims["id"] as Long)
    }


    @GetMapping("/user/court")
    fun getUserCourtVisits(@RequestBody courtId: Long, @RequestBody userId: Long): List<Visit> {
        return visitService.getUserCourtVisits(courtId, userId)
    }

    @DeleteMapping("/visit")
    fun deleteVisit(@RequestBody visitId: Long, @AuthenticationPrincipal principal: Jwt): Int {
        val userId = principal.claims["id"] as Long
        return visitService.deleteVisit(visitId, userId)
    }

    @PostMapping("/visit")
    fun addVisit(@RequestBody @Valid visit: Visit, @AuthenticationPrincipal principal: Jwt) {
        visit.userId = principal.claims["id"] as Long
        visitService.addVisit(visit)
    }

    @PutMapping("/visit")
    fun updateVisitTime(@RequestBody time: LocalTime, @RequestBody id: Long, @AuthenticationPrincipal principal: Jwt): Int {
        val userId = principal.claims["id"] as Long
        return visitService.updateVisitTimeById(time, id, userId)
    }
}