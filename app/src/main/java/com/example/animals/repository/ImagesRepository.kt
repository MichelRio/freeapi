package com.example.animals.repository

import com.example.animals.services.ApiService
import javax.inject.Inject

class ImagesRepository
@Inject
constructor(private val apiService: ApiService){
    suspend fun getImages() = apiService.getImagesService()
}