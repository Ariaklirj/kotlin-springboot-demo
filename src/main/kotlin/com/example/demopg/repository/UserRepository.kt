package com.example.demopg.repository

import com.example.demopg.repository.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User?, Long?> {
    fun findBylastname(lastname: String?): List<User?>?
}
