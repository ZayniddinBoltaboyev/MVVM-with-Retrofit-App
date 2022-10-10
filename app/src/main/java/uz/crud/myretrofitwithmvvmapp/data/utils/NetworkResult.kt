package uz.crud.myretrofitwithmvvmapp.data.utils

sealed class NetworkResult<T: Any> {
    class Success<T: Any>(val code: Int, val data: T) : NetworkResult<T>()
    class Error<T: Any>(val code: Int, val message: String?) : NetworkResult<T>()
    class Loading<T: Any> : NetworkResult<T>()
}