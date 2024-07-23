package halloworld.Courts.repository

import halloworld.Courts.entity.CourtName
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourtNameRepository : JpaRepository<CourtName, Long> {
}