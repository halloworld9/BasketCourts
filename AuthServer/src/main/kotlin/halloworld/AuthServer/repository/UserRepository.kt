package halloworld.AuthServer.repository

import halloworld.AuthServer.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, Long> {


    @Query("select u from User u where u.id = ?1")
    override fun findById(id: Long): Optional<User>


    @Query("select u from User u where upper(u.email) = upper(?1)")
    fun findByEmail(email: String): Optional<User>


    @Query("select u from User u where upper(u.name) = upper(?1)")
    fun findByUsername(username: String): Optional<User>
}