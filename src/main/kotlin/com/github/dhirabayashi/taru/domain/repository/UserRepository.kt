package com.github.dhirabayashi.taru.domain.repository

import com.github.dhirabayashi.taru.domain.entity.User

interface UserRepository {
    fun findAll(): List<User>
}