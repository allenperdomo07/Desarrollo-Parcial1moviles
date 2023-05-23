package com.example.revistas.ui.revista.newrevista

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.revistas.ui.revista.viewmodel.RevistaViewModel

class NewRevistaFragment {
    private lateinit var binding : FragmentNewRevistaBinding

    private val movieViewModel: RevistaViewModel by activityViewModels<RevistaViewModel> {
        RevistaViewModel.Factory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RevistaViewModel.SetNewRevistaFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentNewRevistaBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observerStatus()
    }


    private fun setViewModel(){
        binding.viewmodel = RevistaViewModel
    }

    private fun observerStatus(){
        RevistaViewModel.status.observe(viewLifecycleOwner){
            when{
                it.equals(RevistaViewModel.WRONG_INFORMATION)->{
                    Log.d("APP_TAG", it)
                    RevistaViewModel.clearStatus()
                }
                it.equals(RevistaViewModel.MOVIE_CREATED)->{
                    Log.d("APP_TAG", it)
                    Log.d("APP_TAG", RevistaViewModel.getRevista().toString())

                    RevistaViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}