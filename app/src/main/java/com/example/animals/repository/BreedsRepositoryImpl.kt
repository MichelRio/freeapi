package com.example.animals.repository

import com.example.animals.services.ApiService
import javax.inject.Inject

class BreedsRepositoryImpl
@Inject
constructor(private val apiService: ApiService): BreedsRepository{
    override suspend fun getBreeds(id: String) = apiService.getBreedsService(id)
}