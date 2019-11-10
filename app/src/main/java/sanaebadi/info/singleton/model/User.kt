package sanaebadi.info.singleton.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("email")
    val email: String,

    @Expose
    @SerializedName("username")
    val username: String,

    @Expose
    @SerializedName("image")
    val image: String


) {
    override fun toString(): String {
        return "USER(email : $email , userName : $username , image :$image)"

    }
}