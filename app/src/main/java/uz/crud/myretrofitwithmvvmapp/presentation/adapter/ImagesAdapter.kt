package uz.crud.myretrofitwithmvvmapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.crud.myretrofitwithmvvmapp.databinding.ItemImagesBinding
import uz.crud.myretrofitwithmvvmapp.presentation.model.ImagesModel

class ImagesAdapter : ListAdapter<ImagesModel, ImagesAdapter.ViewHolder>(CommentsDiffutils) {

    inner class ViewHolder(private val binding: ItemImagesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(imagesModel: ImagesModel) {
            Glide.with(binding.root.context)
                .load(imagesModel.url)
                .into(binding.colorImage)
            binding.imageNameTv.text = imagesModel.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object CommentsDiffutils : DiffUtil.ItemCallback<ImagesModel>() {
        override fun areItemsTheSame(oldItem: ImagesModel, newItem: ImagesModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ImagesModel, newItem: ImagesModel): Boolean {
            return oldItem == newItem
        }
    }
}