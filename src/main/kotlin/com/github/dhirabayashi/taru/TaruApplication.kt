package com.github.dhirabayashi.taru

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaruApplication

fun main(args: Array<String>) {
	runApplication<TaruApplication>(*args)
}
