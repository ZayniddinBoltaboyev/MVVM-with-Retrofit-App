package uz.crud.myretrofitwithmvvmapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.crud.myretrofitwithmvvmapp.presentation.model.UserModel
import uz.crud.myretrofitwithmvvmapp.presentation.repository.UserRepository

class MainViewModel(private val userRepository: UserRepository) : ViewModel() {

    val userResponse: MutableLiveData<List<UserModel>> = MutableLiveData()
    val userError: MutableLiveData<String> = MutableLiveData()

    init {
        getUser()
    }

    private fun getUser() {
        val response = userRepository.getUsers()
        response.enqueue(object : Callback<List<UserModel>> {
            override fun onResponse(call: Call<List<UserModel>>, response: Response<List<UserModel>>) {
                if (response.code() == 200) {
                    userResponse.postValue(response.body())
                } else {
                    userError.postValue(response.errorBody().toString())
                    Log.e("TAG", "onResponse: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.localizedMessage}")
            }
        })
    }

}