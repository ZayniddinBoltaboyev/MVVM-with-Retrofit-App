package uz.crud.myretrofitwithmvvmapp.data.utils

sealed class ApiResponse<T>(
    val code: Int? = null,
    val data: T? = null,
    val message: String? = null,
) {
    class Success<T>(code: Int, data: T?) : ApiResponse<T>(code, data)
    class Error<T>(code: Int, data: T?, message: String?) : ApiResponse<T>(code, data, message)
    class Loading<T> : ApiResponse<T>()
}
