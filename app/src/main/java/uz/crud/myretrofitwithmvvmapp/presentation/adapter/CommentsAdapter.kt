package uz.crud.myretrofitwithmvvmapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.crud.myretrofitwithmvvmapp.databinding.ItemCommentsBinding
import uz.crud.myretrofitwithmvvmapp.presentation.model.CommentsModel

class CommentsAdapter(private var list: List<CommentsModel>) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCommentsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCommentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newList = list[position]
        with(holder) {
            binding.nameTv.text = newList.name
            binding.bodyTv.text = newList.body
            binding.emailTv.text = newList.email
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}