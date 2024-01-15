package com.example.animals.repository

import com.example.animals.models.ImagesModelItem
import retrofit2.Response

interface
ImagesRepository {
    suspend fun getImages(): Response<List<ImagesModelItem>>
}