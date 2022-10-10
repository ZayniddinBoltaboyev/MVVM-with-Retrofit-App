package uz.crud.myretrofitwithmvvmapp.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.crud.myretrofitwithmvvmapp.presentation.repository.CommentsRepository
import uz.crud.myretrofitwithmvvmapp.presentation.viewmodel.CommentViewModel

@Suppress("UNCHECKED_CAST")
class CommentsViewModelFactory(private val commentsRepository: CommentsRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CommentViewModel::class.java)) CommentViewModel(commentsRepository) as T
        else throw IllegalArgumentException("")
    }
}