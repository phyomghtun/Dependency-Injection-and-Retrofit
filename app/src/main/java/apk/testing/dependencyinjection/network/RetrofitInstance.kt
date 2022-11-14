package apk.testing.dependencyinjection.network

import apk.testing.dependencyinjection.model.UserData
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInstance {

    @GET("/wt5k_lk/user.json")
    fun getDataFromApi(): Call<UserData>
}