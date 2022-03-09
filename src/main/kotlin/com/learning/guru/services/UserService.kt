package com.learning.guru.services

import com.learning.guru.models.UserModel
import com.learning.guru.pojos.User
import com.learning.guru.repositories.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepo : UserRepository) {

    var log = LoggerFactory.getLogger(UserService::class.java)

    fun createUser(user : User) {

        var existingUser = userRepo.findByName(user.name!!)

        if (existingUser.isEmpty) {
            userRepo.save(UserModel(name = user.name, email = user.email, mobile = user.mobile))
        } else {
            log.error("User already exists")
            throw RuntimeException("User already exists")
        }
    }

    fun getUser(name: String): User {
        val existingUser = userRepo.findByName(name)
        if (existingUser.isEmpty) {
            log.error("User $name doesn't exists")
            throw RuntimeException("User $name doesn't exists", )
        }
        val user = existingUser.get()
        return User(user.name, user.email, user.mobile)
    }

}