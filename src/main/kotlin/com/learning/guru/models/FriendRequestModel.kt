package com.learning.guru.models

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "friend_request")
data class FriendRequestModel(
    @Column(name = "name1", nullable = false)
    var name1: String?,

    @Column(name = "name2", nullable = false)
    var name2: String?,

    @Column(name = "is_friend")
    var isFriend: Boolean
) {
    constructor() : this("", "", false) {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}