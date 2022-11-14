package apk.testing.dependencyinjection.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apk.testing.dependencyinjection.databinding.ItemLayoutBinding
import apk.testing.dependencyinjection.model.User


class UserRvAdapter: RecyclerView.Adapter<UserRvAdapter.ViewHolder>() {
    private var userList : List<User> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setUserList(userList: List<User>){
        this.userList = userList
        notifyDataSetChanged()
    }

   inner class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
       // Log.d("response_msg","Hello")
        return ViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(p0.context),
            p0,false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        if(userList[p1].phone!="") {
            p0.binding.phnumber.text = userList[p1].phone
        }else{
            p0.binding.phnumber.text = "No User"
        }
    }

    override fun getItemCount(): Int = userList.size
}