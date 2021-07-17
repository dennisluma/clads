package com.decagonhq.clads.data.remote

import com.decagonhq.clads.data.domain.GenericResponseClass
import com.decagonhq.clads.data.domain.images.UserProfileImage
import com.decagonhq.clads.data.domain.login.UserRole
import com.decagonhq.clads.data.domain.profile.UserProfile
import com.decagonhq.clads.data.remote.client.Client
import com.decagonhq.clads.data.remote.login.LoginCredentialsDTO
import com.decagonhq.clads.data.remote.registration.UserRegistrationDTO
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {

    /*Register User */
    @POST("artisans/register")
    suspend fun registerUser(@Body user: UserRegistrationDTO): GenericResponseClass<UserProfile>

    /*Email Login*/
    @POST("login")
    suspend fun login(
        @Body loginCredentials: LoginCredentialsDTO
    ): GenericResponseClass<String>

    /*Google Login*/
    @POST("login/google")
    suspend fun googleLogin(
        @Body userRole: UserRole
    ): GenericResponseClass<String>

    @GET("clients")
    suspend fun getClients(): GenericResponseClass<List<Client>>

    @POST("client")
    suspend fun addClient(@Body client: Client): GenericResponseClass<Client>

    @DELETE("client/{clientId}")
    suspend fun deleteClient(@Path("clientId") clientId: Int): GenericResponseClass<List<Client>>

    /*Update User Profile*/
    @PUT("client/{clientId}")
    suspend fun updateClient(@Path("clientId") @Body client: Client): GenericResponseClass<Client>

    /*Upload Profile Picture*/
    @Multipart
    @POST("upload")
    suspend fun uploadImage(@Part image: MultipartBody.Part): GenericResponseClass<UserProfileImage>

    @GET("download")
    fun getUploadedImage(): GenericResponseClass<UserProfileImage>

    /*Get User Profile*/
    @GET("me/profile")
    suspend fun getUserProfile(): GenericResponseClass<UserProfile>

    /*Update User Profile*/
    @PUT("me/profile")
    suspend fun updateUserProfile(@Body userProfile: UserProfile): GenericResponseClass<UserProfile>
}
