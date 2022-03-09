package com.learning.guru.repositories

import com.learning.guru.models.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<UserModel, Long> {

    override fun findById(id : Long) : Optional<UserModel>

    fun findByName(name : String) : Optional<UserModel>

}