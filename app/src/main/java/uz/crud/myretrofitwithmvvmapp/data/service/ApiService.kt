package uz.crud.myretrofitwithmvvmapp.data.service

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import uz.crud.myretrofitwithmvvmapp.presentation.model.CommentsModel
import uz.crud.myretrofitwithmvvmapp.presentation.model.ImagesModel
import uz.crud.myretrofitwithmvvmapp.presentation.model.MessageModel
import uz.crud.myretrofitwithmvvmapp.presentation.model.UserModel

interface ApiService {

    @GET("users")
    fun getUsers(): Call<List<UserModel>>

    @GET("comments")
    fun getComments(): Call<List<CommentsModel>>

    @GET("photos")
    suspend fun getPhotos(): Response<List<ImagesModel>>

    @GET("posts")
    suspend fun getPosts(): Response<List<MessageModel>>

}