package com.learning.guru

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
open class GuruApplication

fun main(args: Array<String>) {
	runApplication<GuruApplication>(*args)
}
