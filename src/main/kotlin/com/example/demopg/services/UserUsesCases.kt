package com.example.demopg.services

import com.example.demopg.repository.entitys.Rol
import com.example.demopg.repository.entitys.RolRepository
import com.example.demopg.repository.entitys.User
import com.example.demopg.repository.entitys.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserUsesCases {
    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var rolRepository: RolRepository

    fun  executeCreateUser(user:User):User {
        user.rol = getRolByLastName(user.lastname)
        return  userRepository.save(user)
    }
    fun executeGetUser(id:Long):User?{
        return  userRepository.findByid(id)
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