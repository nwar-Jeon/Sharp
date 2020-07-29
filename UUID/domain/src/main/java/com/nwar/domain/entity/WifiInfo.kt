package com.nwar.domain.entity

data class WifiInfo(
    val name : String,
    val macAdd : String,
    val strength : Int
) {
    override fun equals(other: Any?): Boolean = if(other is WifiInfo) macAdd == other.macAdd else false

    override fun hashCode(): Int = macAdd.hashCode()
}