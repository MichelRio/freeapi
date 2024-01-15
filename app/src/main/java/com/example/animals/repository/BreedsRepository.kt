package com.example.animals.repository

import com.example.animals.models.BreedModelItem
import retrofit2.Response

interface
BreedsRepository {
    suspend fun getBreeds(id: String): Response<BreedModelItem>
}