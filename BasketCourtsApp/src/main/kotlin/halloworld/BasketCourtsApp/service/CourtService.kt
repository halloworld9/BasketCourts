package halloworld.BasketCourtsApp.service

import halloworld.BasketCourtsApp.entity.Address
import halloworld.BasketCourtsApp.entity.Court
import halloworld.BasketCourtsApp.repository.CourtRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CourtService(
    private val courtRepository: CourtRepository,
) {

    fun getCourtsByCity(city: String): Set<Court> {
        return courtRepository.getCourtsByCity(city)
    }

    @Transactional
    fun saveCourt(court: Court): Court {
        court.apply {
            return courtRepository.save(court)
        }
    }

    fun getCourtByAddress(address: Address): Court {
        address.apply {
            return courtRepository.getCourtByAddress(city, street, number)
        }
    }

    @Transactional
    fun deleteCourtById(id: Long): Int {
        return courtRepository.deleteCourtById(id)
    }
}