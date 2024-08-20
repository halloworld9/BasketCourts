package halloworld.visit.entity

import jakarta.persistence.*
import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name = "visit", uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("date", "time", "user_id"))])
open class Visit(
    @field:NotNull
    @field:FutureOrPresent
    @Column(name = "date", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    open var date: LocalDate,

    @field:NotNull
    @Column(name = "time", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    open var time: LocalTime,

    @field:NotNull
    @Column(name = "court_id", nullable = false)
    open var courtId: Long,

    @field:Null
    @Column(name = "user_id", nullable = false)
    open var userId: Long? = null,

    @Id
    @field:Null(message = "Can't be not null in creation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null
)