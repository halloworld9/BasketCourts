package halloworld.visit.conroller

import halloworld.visit.entity.Visit
import halloworld.visit.service.VisitService
import jakarta.validation.Valid
import org.springframework.format.annotation.DateTimeFormat
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

    @GetMapping("/test")
    fun test(): String {
        return "asd"
    }

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

    @GetMapping("/user/court")
    fun getUserCourtVisits(@RequestBody courtId: Long, @RequestBody userId: Long): List<Visit> {
        return visitService.getUserCourtVisits(courtId, userId)
    }

    @DeleteMapping("/visit")
    fun deleteVisit(@RequestBody visitId: Long): Int {
        return visitService.deleteVisit(visitId)
    }

    @PostMapping("/visit")
    fun addVisit(@RequestBody @Valid visit: Visit) {
        visitService.addVisit(visit)
    }

    @PutMapping("/visit")
    fun updateVisitTime(@RequestBody time: LocalTime, @RequestBody id: Long): Int {
        return visitService.updateVisitTimeById(time, id)
    }
}