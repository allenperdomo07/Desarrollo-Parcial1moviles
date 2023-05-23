package com.example.revistas.ui.revista.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.revistas.data.model.RevistaModel

class RevistaViewModel {
    val name = MutableLiveData("")
    val category = MutableLiveData("")
    val description = MutableLiveData("")
    val qualification = MutableLiveData("")
    val status = MutableLiveData("")

    //logical on back
    private var screenNumber: Int = 0

    fun getScreenFragment()= screenNumber

    fun SetNewRevistaFragment () {
        screenNumber = 2
    }

    fun SetRevistaFragment() {
        screenNumber = 1
    }
    fun SetListaFragment() {
        screenNumber = 0
    }

    fun getRevista () = repository.getRevista()

    private fun addRevista (movie: RevistaModel) = repository.setRevista(revista)

    fun createRevista(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val revista = RevistaModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!,

            )
        addRevista(revista)
        clearData()

        status.value = REVISTA_CREATED
    }

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrBlank() -> return false
            category.value.isNullOrBlank() -> return false
            description.value.isNullOrBlank() -> return false
            qualification.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }
    fun clearStatus(){
        status.value = INACTIVE
    }


}