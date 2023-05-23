package com.example.revistas.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.revistas.data.model.RevistaModel
import com.example.revistas.databinding.FragmentRevistaItemBinding
import java.util.ArrayList

class MovieRecylcerViewAdapter(
    private val clickListener: (RevistaModel)-> Unit
): RecyclerView.Adapter<MovieRecyclerViewHolder>() {
    private val movies = ArrayList<RevistaModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = FragmentRevistaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount()= movies.size

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    fun setData(moviesList: List<RevistaModel>){
        movies.clear()
        movies.addAll(moviesList)
    }

}
