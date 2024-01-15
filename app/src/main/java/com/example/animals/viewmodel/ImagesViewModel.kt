package com.example.animals.viewmodel

import androidx.lifecycle.LiveData
import com.example.animals.models.ImagesModelItem

interface ImagesViewModel {
    val responseImages: LiveData<List<ImagesModelItem>>
    fun loadDataImages()
}