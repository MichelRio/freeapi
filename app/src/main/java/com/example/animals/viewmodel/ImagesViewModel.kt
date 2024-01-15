package com.example.animals.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animals.models.ImagesModel
import com.example.animals.models.ImagesModelItem
import com.example.animals.repository.ImagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel
    @Inject
    constructor(private val repository: ImagesRepository): ViewModel() {

    private val _response = MutableLiveData<List<ImagesModelItem>>()
    val responseImages: LiveData<List<ImagesModelItem>>
        get() = _response

    init {
        getAllImages()
    }

    private fun getAllImages() = viewModelScope.launch {
        repository.getImages().let { response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
                Log.d("ImagesViewModel", "getAllImages Success: ${response.body()}")
            } else {
                Log.d("ImagesViewModel", "getAllImages Error: ${response.code()}")
            }
        }
    }

}