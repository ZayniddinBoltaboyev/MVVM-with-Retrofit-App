package uz.crud.myretrofitwithmvvmapp.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.crud.myretrofitwithmvvmapp.databinding.ItemUsersBinding
import uz.crud.myretrofitwithmvvmapp.presentation.model.UserModel

class UserAdapter(private var userlist: List<UserModel>) :
    ListAdapter<UserModel, UserAdapter.ViewHolder>(UsersDiffutils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(val binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(userModel: UserModel) {
            binding.bodyTv.text = userModel.name
            binding.titleTv.text = userModel.username
        }
    }

    companion object UsersDiffutils : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem == newItem
        }
    }
}