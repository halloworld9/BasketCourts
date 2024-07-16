package halloworld.BasketCourtsApp.repository

import halloworld.BasketCourtsApp.entity.Court
import halloworld.BasketCourtsApp.entity.enums.SurfaceType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface CourtRepository : JpaRepository<Court, Long> {


    @Transactional
    @Modifying
    @Query("update Court c set c.height = ?1 where c.id = ?2")
    fun updateHeightById(height: Int, id: Long): Int

    @Transactional
    @Modifying
    @Query("update Court c set c.surface = ?1 where c.id = ?2")
    fun updateSurfaceTypeById(surfaceType: SurfaceType, id: Long): Int


    @Query("select c from Court c where upper(c.address.city) = upper(?1)")
    fun getCourtsByCity(city: String): Set<Court>


}