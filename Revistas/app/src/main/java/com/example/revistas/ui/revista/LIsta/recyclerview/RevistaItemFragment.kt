package com.example.revistas.ui.revista.LIsta.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RevistaItemFragment {
    private lateinit var binding: FragmentRevistaItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRevistaItemBinding.inflate(inflater, container, false)
        return binding.root
    }
}


