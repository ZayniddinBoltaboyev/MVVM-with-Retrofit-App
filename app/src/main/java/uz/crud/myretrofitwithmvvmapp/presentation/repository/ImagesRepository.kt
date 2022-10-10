package uz.crud.myretrofitwithmvvmapp.presentation.repository

import retrofit2.Response
import uz.crud.myretrofitwithmvvmapp.data.service.RetrofitClient
import uz.crud.myretrofitwithmvvmapp.data.utils.ApiResponse
import uz.crud.myretrofitwithmvvmapp.presentation.model.ImagesModel

class ImagesRepository {

    suspend fun getImages(): Response<List<ImagesModel>> {
        return RetrofitClient.apiService.getPhotos()
    }

}