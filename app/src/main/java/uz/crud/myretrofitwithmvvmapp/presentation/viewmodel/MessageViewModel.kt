package uz.crud.myretrofitwithmvvmapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
import retrofit2.Response
import uz.crud.myretrofitwithmvvmapp.presentation.model.MessageModel
import uz.crud.myretrofitwithmvvmapp.presentation.repository.MessageRepository

class MessageViewModel(private val messageRepository: MessageRepository) : ViewModel() {

    val messageResponse: MutableLiveData<Response<List<MessageModel>>> = MutableLiveData()

    init {
        getMessage()
    }

    private fun getMessage() {
        viewModelScope.launch {
            val response = messageRepository.getMessages()
            if (response.isSuccessful) {
                messageResponse.postValue(Response.success(response.body()))
            } else {
                messageResponse.postValue(Response.error(response.code(), response.errorBody()!!))
            }
        }
    }

}