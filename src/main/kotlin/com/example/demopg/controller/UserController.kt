package com.example.demopg.controller

import com.example.demopg.repository.entities.User
import com.example.demopg.services.CreateUserUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


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
