package com.example.demopg.services

import com.example.demopg.entities.Pet
import com.example.demopg.entities.PetDescription
import com.example.demopg.entities.PetType
import com.example.demopg.gateways.PetGateway
import com.example.demopg.repository.PetRepository
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class PetService(
    private val repo: PetRepository,
    private val gateway: PetGateway
) {
    
    fun findPets() = repo.findAll()
    
    fun findPetDescriptionById(petId: Long): PetDescription {
        val pet = repo.findById(petId).get()
        return gateway.findPetDescriptionById(pet.apiId.toString())
    }
    
    @PostConstruct
    fun bootstrap() {
        repo.save(Pet(null, 52485027, "Dax", PetType.DOG))
        repo.save(Pet(null, 52485026, "Oreo", PetType.CAT))
    }
}
