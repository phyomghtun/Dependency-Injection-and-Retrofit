package apk.testing.dependencyinjection.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import apk.testing.dependencyinjection.R
import apk.testing.dependencyinjection.adapter.UserRvAdapter
import apk.testing.dependencyinjection.databinding.ActivityMainBinding
import apk.testing.dependencyinjection.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var userRvAdapter: UserRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        initRecycler()
        initViewModel()

    }

    fun initRecycler(){
        userRvAdapter = UserRvAdapter()
        activityMainBinding.rView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = userRvAdapter
        }
    }

    fun initViewModel(){
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.loadUserList()
        viewModel.getUserLiveData().observe(this) {
            if (it != null) {
                userRvAdapter.setUserList(it.user)
            }
        }
    }
}