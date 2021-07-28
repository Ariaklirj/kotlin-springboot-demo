package com.example.demopg.repository

import com.example.demopg.entities.Pet
import com.example.demopg.repository.entities.User
import org.springframework.data.repository.CrudRepository

interface PetRepository : CrudRepository<Pet?, Long?>
