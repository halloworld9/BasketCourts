package halloworld.visit.repository

import halloworld.visit.entity.Visit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalTime

@Repository
interface VisitRepository : JpaRepository<Visit, Long> {

    @Query("select v from Visit v where v.courtId = :courtId and v.userId = :userId")
    fun findVisitsByCourtIdAndUserId(courtId: Long, userId: Long): List<Visit>

    @Query("select v from Visit v where v.date = :date and v.courtId = :courtId")
    fun findVisitsByDateAndCourtId(date: LocalDate, courtId: Long): List<Visit>

    @Query("select v from Visit v where v.userId = :userId")
    fun findVisitsByUserId(userId: Long): List<Visit>

    @Modifying
    @Query("delete from Visit v where v.id = :id and v.userId = :userId")
    fun deleteVisitById(id: Long, userId: Long): Int

    fun countVisitsByCourtIdAndDate(courtId: Long, date: LocalDate): Int

    @Modifying
    @Query("update Visit v set v.time = :time where v.id = :id and v.userId = :userId")
    fun updateVisitTimeById(time: LocalTime, id: Long, userId: Long): Int
}