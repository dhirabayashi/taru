package com.github.dhirabayashi.taru.api

import com.github.dhirabayashi.taru.domain.entity.User
import com.github.dhirabayashi.taru.domain.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
    private val userService: UserService
) {
    @GetMapping("greeting")
    fun sample(): String {
        return "Hello!"
    }

    @GetMapping("/users")
    fun user(): List<User> {
        return userService.fetchUsers()
    }
}