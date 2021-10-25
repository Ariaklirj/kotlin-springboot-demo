package com.example.demopg.repository.entitys


import org.springframework.data.repository.CrudRepository
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "\"user\"")
data class User (var firstname: String,
            var lastname: String,
            var description: String? = null,
            @OneToOne
            @JoinColumn(name = "rol_id", referencedColumnName = "id")
            var rol: Rol?=null,
            @Id @GeneratedValue var id: Long? = null
)


interface UserRepository : CrudRepository<User?, Long?> {
    fun findBylastname(lastname: String?): List<User?>?
    fun findByid(id: Long):User?
}