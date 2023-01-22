package com.nazartaraniuk.unsplashtesttask.presentation.main_screen.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nazartaraniuk.unsplashtesttask.databinding.ListItemBinding
import com.nazartaraniuk.unsplashtesttask.presentation.models.PhotoImageUI

class PhotosAdapter(
    private val savePhoto: (ImageView, PhotoImageUI) -> Unit,
    private val loadPhoto: (ImageView, String) -> Unit,
    private val openDetails: (PhotoImageUI, ImageView) -> Unit
) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    private val list = mutableListOf<PhotoImageUI>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<PhotoImageUI>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class PhotoViewHolder(private val binding: ListItemBinding) : ViewHolder(binding.root) {

        fun bind(model: PhotoImageUI) {
            savePhoto(binding.ivLike, model)
            loadPhoto(binding.ivMainImage, model.urls.regular)
            openDetails(model, binding.ivMainImage)
        }
    }
}