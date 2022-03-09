package com.learning.guru.controllers

import com.learning.guru.pojos.User
import com.learning.guru.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class UserController (private val userService: UserService) {

    @RequestMapping(value = ["/user/{name}"], method = [RequestMethod.GET])
    fun getDetails(@PathVariable name: String): ResponseEntity<User> {
        return ResponseEntity(userService.getUser(name), HttpStatus.OK)
    }

    @RequestMapping(value = ["/user"], method = [RequestMethod.POST])
    fun addDetails(@RequestBody user: User): ResponseEntity<User> {
        userService.createUser(user)
        return ResponseEntity(user, HttpStatus.OK)
    }
}