package sanaebadi.info.singleton.api

import retrofit2.http.GET
import retrofit2.http.Path
import sanaebadi.info.singleton.model.User

interface ApiService {
    @GET("placeholder/user/{userId}")
    suspend fun getUser(
        @Path("userId") userId: String
    ): User
}