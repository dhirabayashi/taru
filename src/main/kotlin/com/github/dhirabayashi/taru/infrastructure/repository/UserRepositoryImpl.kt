package com.github.dhirabayashi.taru.infrastructure.repository

import com.github.dhirabayashi.taru.domain.entity.User
import com.github.dhirabayashi.taru.domain.repository.UserRepository
import com.github.dhirabayashi.taru.infrastructure.dao.UserDao
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userDao: UserDao
): UserRepository {
    override fun findAll(): List<User> {
        return userDao.selectAll()
    }
}