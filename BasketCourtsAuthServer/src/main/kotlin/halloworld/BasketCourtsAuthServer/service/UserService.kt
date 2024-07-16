package halloworld.BasketCourtsAuthServer.service

import halloworld.BasketCourtsAuthServer.entity.User
import halloworld.BasketCourtsAuthServer.repository.UserRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserService(private val userRepository: UserRepository) {
    fun findUserById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    fun findUserByEmail(email: String): Optional<User> {
        return userRepository.findByEmail(email)
    }

    fun findUserByUsername(username: String): Optional<User> {
        return userRepository.findByUsername(username)
    }

    fun saveUser(user : User): User {
        return userRepository.save(user)
    }

}