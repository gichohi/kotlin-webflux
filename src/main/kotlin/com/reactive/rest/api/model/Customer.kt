package com.reactive.rest.api.model

import jakarta.persistence.*

@Entity
@Table(name = "customers")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val firstname: String,
    val lastname: String,
    val email: String
)