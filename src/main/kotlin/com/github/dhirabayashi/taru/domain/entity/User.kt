package com.github.dhirabayashi.taru.domain.entity

import org.seasar.doma.*

@Entity(immutable = true)
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int,

    @Column(name = "name")
    val name: String,

    @Column(name = "age")
    val age: Int
)