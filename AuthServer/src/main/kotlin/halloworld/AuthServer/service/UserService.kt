package halloworld.AuthServer.service

import halloworld.AuthServer.entity.Role
import halloworld.AuthServer.entity.User
import halloworld.AuthServer.repository.UserRepository
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository, private val encoder: PasswordEncoder) :
    UserDetailsManager {

    init {
        if (!userExists("admin@yandex.ru")) saveUser(User("admin@yandex.ru", "admin", "12345", Date(), Role.ADMIN))
        if (!userExists("eshkere@yandex.ru")) saveUser(User("eshkere@yandex.ru", "user", "12345", Date(), Role.USER))
    }

    fun findUserById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }


    fun findUserByUsername(username: String): Optional<User> {
        return userRepository.findByUsername(username)
    }

    fun saveUser(user: User): User {
        user.password = encoder.encode(user.password)
        return userRepository.save(user)
    }


    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByEmail(username).get()
    }

    override fun createUser(user: UserDetails) {
        user as User
        user.password = encoder.encode(user.password)
        userRepository.save(user)
    }

    override fun updateUser(user: UserDetails) {
        user as User
        user.run { userRepository.updateUser(email, name, role, password) }
    }

    override fun deleteUser(email: String) {
        userRepository.deleteByEmail(email)
    }

    override fun changePassword(oldPassword: String, newPassword: String) {
        val currentUser: Authentication = SecurityContextHolder.getContext().authentication
            ?: throw org.springframework.security.access.AccessDeniedException(
                "Can't change password as no Authentication object found in context " + "for current user."
            )
        userRepository.updatePasswordByEmail(newPassword, currentUser.name)

    }

    override fun userExists(email: String): Boolean {
        return userRepository.existsByEmail(email)
    }

}