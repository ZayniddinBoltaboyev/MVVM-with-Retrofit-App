package uz.crud.myretrofitwithmvvmapp.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.crud.myretrofitwithmvvmapp.presentation.repository.ImagesRepository
import uz.crud.myretrofitwithmvvmapp.presentation.viewmodel.ImageViewModel

@Suppress("UNCHECKED_CAST")
class ImagesViewModelFactory(private val imagesRepository: ImagesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ImageViewModel::class.java)) ImageViewModel(imagesRepository) as T
        else throw IllegalArgumentException("")
    }
}