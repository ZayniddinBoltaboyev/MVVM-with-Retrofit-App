package uz.crud.myretrofitwithmvvmapp.presentation.repository

import retrofit2.Call
import uz.crud.myretrofitwithmvvmapp.data.service.RetrofitClient
import uz.crud.myretrofitwithmvvmapp.presentation.model.UserModel

class UserRepository {

    fun getUsers(): Call<List<UserModel>> {
        return RetrofitClient.apiService.getUsers()
    }

}