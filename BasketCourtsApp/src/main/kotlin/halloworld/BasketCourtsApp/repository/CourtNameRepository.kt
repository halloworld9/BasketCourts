package halloworld.BasketCourtsApp.repository

import halloworld.BasketCourtsApp.entity.CourtName
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourtNameRepository : JpaRepository<CourtName, Long> {
}