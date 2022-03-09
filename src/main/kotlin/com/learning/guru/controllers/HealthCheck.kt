package com.learning.guru.controllers

import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.collections.set

@RestController
@Slf4j
class HealthCheck {

    @RequestMapping(value = ["/v1/health_check"], method = [RequestMethod.GET])
    fun healthCheck(): ResponseEntity<MutableMap<String, String>> {
        val result: MutableMap<String, String> = mutableMapOf()
        result["status"] = "Flying like a rocket"
        return ResponseEntity(result, HttpStatus.OK)
    }

}