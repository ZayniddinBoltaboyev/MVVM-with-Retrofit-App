package uz.crud.myretrofitwithmvvmapp.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.crud.myretrofitwithmvvmapp.presentation.repository.MessageRepository
import uz.crud.myretrofitwithmvvmapp.presentation.viewmodel.MessageViewModel

@Suppress("UNCHECKED_CAST")
class MessageViewModelFactory(private val messageRepository: MessageRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MessageViewModel::class.java)) MessageViewModel(messageRepository) as T
        else throw IllegalArgumentException("Unknown ViewModel")
    }
}