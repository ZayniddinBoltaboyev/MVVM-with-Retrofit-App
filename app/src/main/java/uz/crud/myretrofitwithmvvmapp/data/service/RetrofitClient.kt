package uz.crud.myretrofitwithmvvmapp.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.crud.myretrofitwithmvvmapp.data.utils.Constants.Companion.BASE_URL

object RetrofitClient {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}