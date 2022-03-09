package com.learning.guru.controllers

import com.learning.guru.pojos.Friends
import com.learning.guru.services.FriendRequestService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class FriendRequestController (val friendRequestService: FriendRequestService) {

    @PostMapping(value = ["/friend/request/{name1}/{name2}"])
    fun createRequest(@PathVariable name1 : String, @PathVariable name2: String) : ResponseEntity<Void> {
        friendRequestService.createRequest(name1, name2)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping(value = ["/friends/{name1}"])
    fun getFriends(@PathVariable name1 : String) : ResponseEntity<Friends> {
        val friends : Friends = friendRequestService.getFriends(name1)
        return ResponseEntity(friends, HttpStatus.CREATED)
    }

    @GetMapping(value = ["/pending/request/{name1}"])
    fun getPendingRequests(@PathVariable name1 : String) : ResponseEntity<Friends> {
        val friends : Friends = friendRequestService.getPendingRequest(name1)
        return ResponseEntity(friends, HttpStatus.CREATED)
    }

}