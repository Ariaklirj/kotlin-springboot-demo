package com.example.demopg.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pets")
data class Pet(
    @Id @GeneratedValue
    var id: Long? = null,
    
    var apiId: Long,
    val name: String,
    val type: PetType
)

enum class PetType {
    CAT, DOG
}

data class Animal(
    val animal: PetDescription
)

data class PetDescription(
    val description: String
)
