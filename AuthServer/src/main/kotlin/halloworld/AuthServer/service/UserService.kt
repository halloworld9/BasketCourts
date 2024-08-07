package halloworld.AuthServer.service

import halloworld.AuthServer.entity.User
import halloworld.AuthServer.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository, private val encoder: PasswordEncoder) : UserDetailsService {

    init {
        saveUser(User("admin@yandex.ru", "admin", "12345", Date()))
        saveUser(User("eshkere@yandex.ru", "user", "12345", Date()))
    }

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
        user.password = encoder.encode(user.password)
        return userRepository.save(user)
    }

        

    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByEmail(username).get()
    }

}