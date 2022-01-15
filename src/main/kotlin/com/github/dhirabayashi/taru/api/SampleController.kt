package com.github.dhirabayashi.taru.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {
    @GetMapping("greeting")
    fun sample(): String {
        return "Hello!"
    }
}