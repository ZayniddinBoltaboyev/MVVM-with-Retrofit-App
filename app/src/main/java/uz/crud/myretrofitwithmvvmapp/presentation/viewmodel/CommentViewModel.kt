package uz.crud.myretrofitwithmvvmapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.crud.myretrofitwithmvvmapp.presentation.model.CommentsModel
import uz.crud.myretrofitwithmvvmapp.presentation.repository.CommentsRepository

class CommentViewModel(private val commentsRepository: CommentsRepository) : ViewModel() {

    val commentsResponse: MutableLiveData<List<CommentsModel>> = MutableLiveData()

    fun getComments() {
        commentsRepository.getComments(commentsResponse)
    }

}