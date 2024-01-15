package com.example.animals.viewmodel

import androidx.lifecycle.LiveData
import com.example.animals.models.BreedModelItem

interface BreedsViewModel {
    val responseBreeds: LiveData<BreedModelItem>
    fun loadDataBreeds(id: String?)
}