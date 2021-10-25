package com.example.demopg.controller

import com.example.demopg.repository.entitys.User
import com.example.demopg.services.UserUsesCases
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    lateinit var userUsesCases: UserUsesCases

    @PostMapping("")
    @ResponseBody

    fun healt(){
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id:Long):User?{
        val user = userUsesCases.executeGetUser(id)
        return user
    }


    @PostMapping("/create")
    @ResponseBody
    fun postResponseController(
        @RequestBody user: User
    ):ResponseEntity<*> {
        var response = userUsesCases.executeCreateUser(user)

        return ResponseEntity.ok().body(response)

    }
}