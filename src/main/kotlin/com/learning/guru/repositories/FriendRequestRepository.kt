package com.learning.guru.repositories

import com.learning.guru.models.FriendRequestModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface FriendRequestRepository : JpaRepository<FriendRequestModel, Long> {

    fun findByName1AndName2(name1 : String, name2 : String) : Optional<FriendRequestModel>

    fun findByName1(name1 : String) : List<FriendRequestModel>

}