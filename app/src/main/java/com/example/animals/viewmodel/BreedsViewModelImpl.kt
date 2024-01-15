package com.example.animals.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animals.models.BreedModelItem
import com.example.animals.repository.BreedsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedsViewModelImpl
    @Inject
    constructor(private val repository: BreedsRepositoryImpl): ViewModel(), BreedsViewModel {

    private val _response = MutableLiveData<BreedModelItem>()
    override val responseBreeds: LiveData<BreedModelItem>
        get() = _response

    override fun loadDataBreeds(id: String?) {
        viewModelScope.launch {
            repository.getBreeds(id!!).let { response ->
                if (response.isSuccessful) {
                    _response.postValue(response.body())
                    Log.d("BreedsViewModelImp", "loadDataBreeds Success: ${response.body()}")
                } else {
                    Log.d("BreedsViewModelImp", "loadDataBreeds Error: ${response.code()}")
                }
            }
        }
    }

}