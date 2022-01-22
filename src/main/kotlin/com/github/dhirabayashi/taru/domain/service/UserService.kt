package com.github.dhirabayashi.taru.domain.service

import com.github.dhirabayashi.taru.domain.entity.User
import com.github.dhirabayashi.taru.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun fetchUsers(): List<User> {
        return userRepository.findAll()
    }
}