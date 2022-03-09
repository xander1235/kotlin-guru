package com.learning.guru.pojos

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Builder
class Friends {

    var count : Int = 0

    lateinit var friends : List<String>
}