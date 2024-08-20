package halloworld.Courts.service

import halloworld.Courts.entity.Address
import halloworld.Courts.entity.Court
import halloworld.Courts.entity.enums.SurfaceType
import halloworld.Courts.repository.CourtRepository
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