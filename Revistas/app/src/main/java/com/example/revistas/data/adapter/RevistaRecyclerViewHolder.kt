package com.example.revistas.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.revistas.data.model.RevistaModel
import java.util.ArrayList

class RevistaRecyclerViewHolder {
    private val clickListener: (RevistaModel)-> Unit
    ): RecyclerView.Adapter<RevistaRecyclerViewHolder>() {
        private val revista = ArrayList<RevistaModel>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RevistaRecyclerViewHolder {
            val binding = FragmentRevistaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RevistaRecyclerViewHolder(binding)
        }

        override fun getItemCount()= revista.size

        override fun onBindViewHolder(holder: RevistaRecyclerViewHolder, position: Int) {
            val movie = revista[position]
            holder.bind(movie, clickListener)
        }

        fun setData(moviesList: List<RevistaModel>){
            revista.clear()
            revista.addAll(moviesList)
        }
}