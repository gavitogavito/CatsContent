package com.example.catscontent.data.remote

import com.example.catscontent.data.remote.breed.BreedDtoItem
import com.example.catscontent.data.remote.cat.CatDtoItem
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {

    @GET("breeds")
    suspend fun getBreeds(): List<BreedDtoItem>

    @GET("images/search?")
    suspend fun getBreedById(
        @Query("breed_ids") breedId: String
    ): List<CatDtoItem>
}