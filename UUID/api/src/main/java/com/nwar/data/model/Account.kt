package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class Account(
    @SerializedName("id")
    val id : String = "",
    @SerializedName("password")
    val password : String = "",
    @SerializedName("username")
    val username : String = "",
    @SerializedName("access_token")
    val token : String = ""
) {
}