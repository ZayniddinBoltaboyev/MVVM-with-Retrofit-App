package uz.crud.myretrofitwithmvvmapp.presentation.model

data class CommentsModel(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)