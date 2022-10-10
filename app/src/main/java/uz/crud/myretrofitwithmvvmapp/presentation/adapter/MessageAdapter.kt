package uz.crud.myretrofitwithmvvmapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.crud.myretrofitwithmvvmapp.databinding.ItemMessageBinding
import uz.crud.myretrofitwithmvvmapp.presentation.model.MessageModel

class MessageAdapter : ListAdapter<MessageModel, MessageAdapter.MessageViewHolder>(MessageDiffUtils) {

    inner class MessageViewHolder(private val binding: ItemMessageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(messageModel: MessageModel) {
            binding.titleTv.text = messageModel.title
            binding.bodyTv.text = messageModel.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object MessageDiffUtils : DiffUtil.ItemCallback<MessageModel>() {
        override fun areItemsTheSame(oldItem: MessageModel, newItem: MessageModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MessageModel, newItem: MessageModel): Boolean {
            return oldItem == newItem
        }
    }
}
