package sanaebadi.info.singleton.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "email")
    val email: String,

    @Json(name = "username")
    var username: String,

    @Json(name = "image")
    val image: String


) {
    override fun toString(): String {
        return "USER(email : $email , userName : $username , image :$image)"

    }
}