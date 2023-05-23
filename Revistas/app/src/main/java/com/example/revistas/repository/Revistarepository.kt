package com.example.revistas.repository

import com.example.revistas.data.model.RevistaModel

class RevistarepositoryRepository (private  val revista: MutableList<RevistaModel>){
    fun getMovies () = revista

    fun setMovies (movie: RevistaModel) = revista.add(movie)
}