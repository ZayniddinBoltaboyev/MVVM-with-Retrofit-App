package uz.crud.myretrofitwithmvvmapp.presentation.repository

import uz.crud.myretrofitwithmvvmapp.data.service.ApiService

class MessageRepository(private val apiService: ApiService) {
    suspend fun getMessages() = apiService.getPosts()
}