package com.example.mvvmkotlinapp.viewholder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmkotlinapp.databinding.SearchInfoItemBinding
import com.example.mvvmkotlinapp.model.Result

class MovieViewHolder(private val searchInfoItemBinding: SearchInfoItemBinding) :
    RecyclerView.ViewHolder(searchInfoItemBinding.root) {

    fun bind(result: Result) {
        searchInfoItemBinding.executePendingBindings()
        searchInfoItemBinding.result = result
        loadImage(searchInfoItemBinding.image, "http://image.tmdb.org/t/p/w92/" + result.posterPath)

    }


    private fun loadImage(view: ImageView, imageUrl: String?) {
        Glide.with(view.context)
            .load(imageUrl).apply(RequestOptions().circleCrop())
            .into(view)
    }

}

