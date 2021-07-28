package com.example.demopg.repository.entities


import com.example.demopg.entities.Rol
import org.springframework.data.repository.CrudRepository
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    var firstname: String,
    
    var lastname: String,
    
    var description: String? = null,
    
    @OneToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    var rol: Rol? = null,
    
    @Id @GeneratedValue
    var id: Long? = null
)
