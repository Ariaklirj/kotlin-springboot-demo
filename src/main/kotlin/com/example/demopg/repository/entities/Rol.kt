package com.example.demopg.repository.entitys

import org.springframework.data.repository.CrudRepository
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Rol (var description: String?,
            var name: String,
            @Id @GeneratedValue var id: Long? = null
){
    private constructor() : this("","")
}


interface RolRepository : CrudRepository<Rol?, Long?> {
    fun findByname(lastname: String?): List<Rol?>?
    override fun findById(id: Long): Optional<Rol?>
}