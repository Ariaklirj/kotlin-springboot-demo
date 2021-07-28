package com.example.demopg.services

import com.example.demopg.entities.Rol
import com.example.demopg.repository.RolRepository
import com.example.demopg.repository.UserRepository
import com.example.demopg.repository.entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CreateUserUseCase {
    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var rolRepository: RolRepository

    fun  execute(user:User):User {
        user.rol = getRolByLastName(user.lastname)
        return  userRepository.save(user)
    }

    fun getRolByLastName(lastname: String) : Rol?{

       return when (lastname.first().lowercase()){
            "l" -> rolRepository.findByIdOrNull(1)
            "H" -> rolRepository.findByIdOrNull(2)
            "M" ->  rolRepository.findByIdOrNull(3)
            "C" ->  rolRepository.findByIdOrNull(4)
            "A" ->  rolRepository.findByIdOrNull(5)
           else ->  null
       }

    }

}
