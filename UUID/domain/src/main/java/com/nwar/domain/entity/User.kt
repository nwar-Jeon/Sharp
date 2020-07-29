package com.nwar.domain.entity

data class User(
    val id : String,
    val password : String,
    val name : String,
    val token : String
) {
}