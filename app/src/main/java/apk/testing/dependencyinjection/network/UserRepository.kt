package apk.testing.dependencyinjection.network

import androidx.lifecycle.MutableLiveData
import apk.testing.dependencyinjection.model.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val retrofitInstance: RetrofitInstance) {

    fun makeApiCall(liveDataList : MutableLiveData<UserData>){
        val call : Call<UserData> = retrofitInstance.getDataFromApi()
        call.enqueue(object : Callback<UserData>{
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }
}