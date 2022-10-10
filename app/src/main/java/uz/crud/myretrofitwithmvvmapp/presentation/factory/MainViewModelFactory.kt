package uz.crud.myretrofitwithmvvmapp.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.crud.myretrofitwithmvvmapp.presentation.repository.UserRepository
import uz.crud.myretrofitwithmvvmapp.presentation.viewmodel.MainViewModel

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) MainViewModel(userRepository) as T
        else throw IllegalArgumentException("")
    }
}