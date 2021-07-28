package com.example.demopg.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Rol(
    var description: String?,
    var name: String,
    @Id @GeneratedValue var id: Long? = null
) {
    private constructor() : this("", "")
}
