package uz.crud.myretrofitwithmvvmapp.presentation.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.crud.myretrofitwithmvvmapp.data.service.RetrofitClient
import uz.crud.myretrofitwithmvvmapp.presentation.model.CommentsModel

class CommentsRepository {

    fun getComments(commentsResponse: MutableLiveData<List<CommentsModel>>) {
        Log.e("TAG", "getComments: $commentsResponse" )
        RetrofitClient.apiService.getComments().enqueue(object : Callback<List<CommentsModel>> {
            override fun onResponse(
                call: Call<List<CommentsModel>>,
                response: Response<List<CommentsModel>>,
            ) {
                if (response.code() == 200) {
                    Log.e("TAG", "onResponse: ${response.body()}")
                    commentsResponse.postValue(response.body())
                } else {
                    Log.e("TAG", "onResponse: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<CommentsModel>>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.localizedMessage}")
            }
        })
    }

}