package com.example.revistas.data.adapter

import com.example.revistas.data.model.RevistaModel

class RevistaRecyclerViewAdapter {
    fun bind(revista : RevistaModel, clickListener: (RevistaModel) -> Unit){
        binding.textViewName.text = revista.name
        binding.textViewQualification.text = revista.qualification

        binding.cardViewMovie.setOnClickListener{
            clickListener(movie)
        }
    }


}
