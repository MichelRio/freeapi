package com.example.animals.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.animals.R
import com.example.animals.databinding.ImageItemBinding
import com.example.animals.models.ImagesModel
import com.example.animals.models.ImagesModelItem
import com.squareup.picasso.Picasso

class ImagesAdapter: RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>() {

    inner class ImagesViewHolder (val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<ImagesModelItem>(){
        override fun areItemsTheSame(oldItem: ImagesModelItem, newItem: ImagesModelItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ImagesModelItem,
            newItem: ImagesModelItem
        ): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var imageList : List<ImagesModelItem>
        get() = differ.currentList
        set(value){
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        return ImagesViewHolder(ImageItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val currentItem = imageList[position]
        holder.binding.apply {
            tvTitle.text = currentItem.id
            Picasso.get()
                .load(currentItem.url)
                .placeholder(R.drawable.icon_placeholder)
                .error(R.drawable.icon_error)
                .into(ivImage)
        }
    }
}




















