package com.example.demopg.controller

import com.example.demopg.repository.entitys.User
import com.example.demopg.services.CreateUserUseCase
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
    lateinit var createUserUseCase: CreateUserUseCase

    @PostMapping("")
    @ResponseBody

    fun healt(){
    }

    @PostMapping("/create")
    @ResponseBody
    fun postResponseController(
        @RequestBody user: User
    ):ResponseEntity<*> {
        var response = createUserUseCase.execute(user)

        return ResponseEntity.ok().body(user)

    }
}