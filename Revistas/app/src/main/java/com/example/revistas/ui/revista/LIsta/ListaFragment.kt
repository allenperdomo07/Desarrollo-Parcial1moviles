package com.example.revistas.ui.revista.LIsta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.revistas.data.adapter.RevistaRecyclerViewAdapter
import com.example.revistas.data.model.RevistaModel
import com.example.revistas.ui.revista.viewmodel.RevistaViewModel

class ListaFragment {
    /UI
    private lateinit var recyclerViewRevista: RecyclerView
    private lateinit var binding : FragmentListaBinding
    private  lateinit var adapter: RevistaRecyclerViewAdapter
    private val movieViewModel: RevistaViewModel by activityViewModels<RevistaViewModel> {
        RevistaViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentListaBinding.inflate(inflater, container , false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        bind()
        listeners()
//


        setRecyclerView(view)

    }

    private fun bind(){

        recyclerViewRevista = view?.findViewById(R.id.revista_recycle_view) as RecyclerView
    }

    private fun listeners(){

        binding.btnLinkNewMovie.setOnClickListener{
            RevistaViewModel.clearData()
            it.findNavController().navigate(R.id.action_listaFragment_to_newRevistaFragment)
        }
    }


    private fun showSelectedItem(movie: RevistaModel){
        movieViewModel.setSelectedRevista(revista)
        findNavController().navigate(R.id.action_listaFragment_to_revistaFragment)
    }

    private fun displayMovies(){
        adapter.setData(RevistaViewModel.getRevista())
        adapter.notifyDataSetChanged()
    }
    private fun setRecyclerView(view: View){
        binding.revistarecyclerview.layoutManager = LinearLayoutManager(view.context)

        adapter = revistaRecyclerViewAdapter() { selectedRevista ->
            showSelectedItem(selectedRevista)
        }

        binding.revistaRecycleView.adapter = adapter
        displayMovies()
    }
}