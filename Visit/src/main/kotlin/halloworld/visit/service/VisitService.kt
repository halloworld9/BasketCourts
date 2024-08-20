package halloworld.visit.service

import halloworld.visit.entity.Visit
import halloworld.visit.repository.VisitRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.LocalTime

@Service
class VisitService(private val visitRepository: VisitRepository) {

    fun getUserCourtVisits(courtId: Long, userId: Long): List<Visit> {
        return visitRepository.findVisitsByCourtIdAndUserId(courtId, userId)
    }

    fun getCourtVisitsOnDay(date: LocalDate, courtId: Long): List<Visit> {
        return visitRepository.findVisitsByDateAndCourtId(date, courtId)
    }

    fun getCountOfCourtVisitsOnDay(date: LocalDate, courtId: Long): Int {
        return visitRepository.countVisitsByCourtIdAndDate(courtId, date)

    }

    fun getUserVisits(userId: Long): List<Visit> {
        return visitRepository.findVisitsByUserId(userId)
    }

    @Transactional
    fun deleteVisit(visitId: Long, userId: Long): Int {
        return visitRepository.deleteVisitById(visitId, userId)
    }

    @Transactional
    fun addVisit(visit: Visit) {
        visitRepository.saveAndFlush(visit)
    }

    @Transactional
    fun updateVisitTimeById(time: LocalTime, id: Long, userId: Long): Int {
        return visitRepository.updateVisitTimeById(time, id, userId)
    }

}