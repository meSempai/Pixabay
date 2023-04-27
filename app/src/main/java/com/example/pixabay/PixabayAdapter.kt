package com.example.pixabay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.pixabay.databinding.ItemImageBinding

class PixabayAdapter(var list: ArrayList<ImageModel>) :
    RecyclerView.Adapter<PixabayAdapter.PixabayViewHolder>() {
    class PixabayViewHolder(var binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun bind(imageModel: ImageModel) {
            binding.photoView.load(imageModel.largeImageUrl)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixabayViewHolder {
        return PixabayViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PixabayViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
