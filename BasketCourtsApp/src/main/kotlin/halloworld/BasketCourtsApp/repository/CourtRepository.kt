package halloworld.BasketCourtsApp.repository

import halloworld.BasketCourtsApp.entity.Court
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CourtRepository : JpaRepository<Court, Long> {

    @Query("select c from Court c where upper(c.address.city) = upper(?1)")
    fun getCourtsByCity(city: String): Set<Court>


    @Query("select c from Court c where c.address.city = ?1 and c.address.street = ?2 and c.address.number = ?3")
    fun getCourtByAddress(city: String, street: String, number: String): Court


    @Modifying
    @Query("delete from Court c where c.id = :id")
    fun deleteCourtById(id: Long): Int
}