package com.example.demopg.repository

import com.example.demopg.entities.Rol
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface RolRepository : CrudRepository<Rol?, Long?> {
    fun findByname(lastname: String?): List<Rol?>?
    override fun findById(id: Long): Optional<Rol?>
}
