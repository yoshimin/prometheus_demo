package com.example.demo

import javax.persistence.*

@Entity
@Table(name = "cart")
data class Item(
    @Id @GeneratedValue val id: Long?,
    val name: String
)
