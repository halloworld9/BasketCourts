package halloworld.AuthServer.repository

import halloworld.AuthServer.entity.Role
import halloworld.AuthServer.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, Long> {


    @Query("select u from User u where u.id = ?1")
    override fun findById(id: Long): Optional<User>


    @Query("select u from User u where upper(u.email) = upper(?1)")
    fun findByEmail(email: String): Optional<User>


    @Query("select u from User u where upper(u.name) = upper(?1)")
    fun findByUsername(username: String): Optional<User>


    @Transactional
    @Modifying
    @Query("delete from User u where upper(u.email) = upper(:email)")
    fun deleteByEmail(email: String)


    @Query("select (count(u) > 0) from User u where upper(u.email) = upper(:email)")
    fun existsByEmail(email: String): Boolean


    @Transactional
    @Modifying
    @Query(
        """update User u set u.name = :name, u.password = :password, u.role = :role
    where upper(u.email) = upper(:email)"""
    )
    fun updateUser(name: String, password: String, role: Role, email: String)


    @Transactional
    @Modifying
    @Query("update User u set u.password = :password where upper(u.email) = upper(:email)")
    fun updatePasswordByEmail(password: String, email: String): Int
}