package com.example.animals.services

import com.example.animals.models.BreedModelItem
import com.example.animals.models.ImagesModelItem
import retrofit2.*
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(Endpoints.ENDPOINT_IMAGES)
    suspend fun getImagesService(): Response<List<ImagesModelItem>>

    @GET(Endpoints.ENDPOINT_BREEDS)
    suspend fun getBreedsService(@Path("id") id: String): Response<BreedModelItem>

}