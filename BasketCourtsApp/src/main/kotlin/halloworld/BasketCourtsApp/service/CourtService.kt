package halloworld.BasketCourtsApp.service

import halloworld.BasketCourtsApp.entity.Address
import halloworld.BasketCourtsApp.entity.Court
import halloworld.BasketCourtsApp.entity.enums.SurfaceType
import halloworld.BasketCourtsApp.repository.AddressRepository
import halloworld.BasketCourtsApp.repository.CourtRepository
import org.springframework.stereotype.Service

@Service
class CourtService(
    private val courtRepository: CourtRepository,
    private val addressRepository: AddressRepository,
) {

    fun getCourtsByCity(city: String) : Set<Court> {
        return courtRepository.getCourtsByCity(city)
    }

    fun updateSurfaceTypeById(surfaceType: SurfaceType, id: Long): Int {
        return courtRepository.updateSurfaceTypeById(surfaceType, id)
    }

    fun updateSurfaceTypeById(surfaceType: String, id: Long): Int {
        val surface = SurfaceType.valueOf(surfaceType)
        return courtRepository.updateSurfaceTypeById(surface, id)
    }

    fun saveCourt(city: String, street: String, number: String,
                  surface: String, height: Int = 0): Court {
        val address = addressRepository.save(Address(city, street, number))
        val surfaceType = SurfaceType.valueOf(surface)
        val court = Court(address, surfaceType, height)
        return courtRepository.save(court)
    }
}