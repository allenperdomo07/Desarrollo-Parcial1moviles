package com.example.revistas.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.revistas.data.model.RevistaModel
import com.example.revistas.databinding.FragmentRevistaItemBinding
import java.util.ArrayList

class MovieRecyclerViewHolder(private val binding: FragmentRevistaItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie : RevistaModel, clickListener: (RevistaModel) -> Unit){
        binding.textViewName.text = movie.name
        binding.textViewQualification.text = movie.qualification

        binding.cardViewMovie.setOnClickListener{
            clickListener(movie)
        }
    }
}