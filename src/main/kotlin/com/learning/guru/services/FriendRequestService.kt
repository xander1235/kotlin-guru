package com.learning.guru.services

import com.learning.guru.models.FriendRequestModel
import com.learning.guru.pojos.Friends
import com.learning.guru.repositories.FriendRequestRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FriendRequestService
@Autowired constructor( private val friendRequestRepo : FriendRequestRepository,
                        private val userService : UserService) {

    val log = LoggerFactory.getLogger(FriendRequestService::class.java)

    fun createRequest(name1 : String, name2 : String) {

        if (name1 == name2) {
            throw RuntimeException("Cannot send the request to self account")
        }
        userService.getUser(name1)
        userService.getUser(name2)

        val existingRequest = friendRequestRepo.findByName1AndName2(name1, name2)

        if (existingRequest.isPresent) {
            throw RuntimeException("Friend request already pending")
        }

        var request = FriendRequestModel(name1, name2, false)

        var friendRequestOptional = friendRequestRepo.findByName1AndName2(name2, name1)
        if (friendRequestOptional.isPresent) {
            var friendRequest = friendRequestOptional.get()
            friendRequest.isFriend = true
            request.isFriend = true
            friendRequestRepo.save(friendRequest)
        }

        friendRequestRepo.save(request)

    }

    fun getFriends(name1 : String) : Friends {
        return getFriendsRequests(name1, true)
    }

    fun getPendingRequest(name1 : String) : Friends {
        return getFriendsRequests(name1, false)
    }

    private fun getFriendsRequests(name1 : String, flag : Boolean) : Friends {
        userService.getUser(name1)

        var friendsFromDB = friendRequestRepo.findByName1(name1)
        val friendsList = mutableListOf<String>()
        for( friend in friendsFromDB) {
            if (!(friend.isFriend xor flag)) {
                friendsList.add(friend.name2!!)
                log.info("added friends: {} from: {}", friendsList, friend)
            }
        }

        val friends = Friends()
        friends.count = friendsList.size
        friends.friends = friendsList

        return friends
    }
}