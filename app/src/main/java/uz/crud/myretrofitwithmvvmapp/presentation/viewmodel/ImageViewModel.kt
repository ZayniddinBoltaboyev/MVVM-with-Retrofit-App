package uz.crud.myretrofitwithmvvmapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.crud.myretrofitwithmvvmapp.data.utils.ApiResponse
import uz.crud.myretrofitwithmvvmapp.presentation.model.ImagesModel
import uz.crud.myretrofitwithmvvmapp.presentation.repository.ImagesRepository

class ImageViewModel(private val imagesRepository: ImagesRepository) : ViewModel() {

    val imagesResponse: MutableLiveData<ApiResponse<List<ImagesModel>>> = MutableLiveData()

    fun getImages() {
        viewModelScope.launch {
            imagesResponse.postValue(ApiResponse.Loading())
            val response = imagesRepository.getImages()
            if (response.isSuccessful) {
                imagesResponse.postValue(ApiResponse.Success(response.code(), response.body()))
            } else {
                imagesResponse.postValue(ApiResponse.Error(response.code(), null, response.message()))
            }
        }
    }
}