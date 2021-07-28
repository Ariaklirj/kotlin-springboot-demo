package com.example.demopg.controller

import com.example.demopg.services.PetService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pets")
class PetsController(
    private val srv: PetService
) {
    
    @GetMapping
    fun findAll() = ResponseEntity.ok(srv.findPets())
    
    @GetMapping  ("/{id}")
    fun findDescriptionById(
        @PathVariable id: Long
    ) = ResponseEntity.ok(srv.findPetDescriptionById(id))
}
