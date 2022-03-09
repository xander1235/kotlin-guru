package com.learning.guru.models

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
data class UserModel (
    @Column(name="name", nullable = false)
    var name : String?,
    @Column(name="email", nullable = false)
    var email : String?,

    @Column(name="mobile", nullable = false)
    var mobile : String?,

) {
    constructor() : this("", "", "") {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}