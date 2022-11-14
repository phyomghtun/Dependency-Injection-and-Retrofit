package apk.testing.dependencyinjection.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import apk.testing.dependencyinjection.model.UserData
import apk.testing.dependencyinjection.network.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {
    var liveDataList = MutableLiveData<UserData>()

    init {
        liveDataList = MutableLiveData()
    }

    fun getUserLiveData(): MutableLiveData<UserData> {
        return liveDataList
    }

    fun loadUserList(){
       userRepository.makeApiCall(liveDataList)
    }
}