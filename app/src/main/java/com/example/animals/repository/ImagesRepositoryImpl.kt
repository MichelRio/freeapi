package com.example.animals.repository

import com.example.animals.services.ApiService
import javax.inject.Inject

class ImagesRepositoryImpl
@Inject
constructor(private val apiService: ApiService): ImagesRepository{
    override suspend fun getImages() = apiService.getImagesService()
}