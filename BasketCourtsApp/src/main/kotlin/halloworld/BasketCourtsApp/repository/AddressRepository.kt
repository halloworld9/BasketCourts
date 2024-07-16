package halloworld.BasketCourtsApp.repository

import halloworld.BasketCourtsApp.entity.Address
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : CrudRepository<Address, Long> {

}