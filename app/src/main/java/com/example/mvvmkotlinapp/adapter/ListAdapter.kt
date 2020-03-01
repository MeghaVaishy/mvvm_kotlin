package com.example.mvvmkotlinapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmkotlinapp.databinding.SearchInfoItemBinding
import com.example.mvvmkotlinapp.model.Result
import com.example.mvvmkotlinapp.viewholder.MovieViewHolder
import io.reactivex.subjects.PublishSubject

class ListAdapter(private val movieList: List<Result>) : RecyclerView.Adapter<MovieViewHolder>() {


    var publishSubject: PublishSubject<Result> = PublishSubject.create()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val searchInfoItemBinding: SearchInfoItemBinding =
            SearchInfoItemBinding.inflate(LayoutInflater.from(parent.context))
        searchInfoItemBinding.root.setOnClickListener {
            // Item Click

        }
        return MovieViewHolder(searchInfoItemBinding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }
}