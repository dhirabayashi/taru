package com.github.dhirabayashi.taru.infrastructure.dao

import com.github.dhirabayashi.taru.domain.entity.User
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable

@ConfigAutowireable
@Dao
interface UserDao {
    @Select
    fun selectAll(): List<User>
}