package com.example.catscontent.domain.repository

import com.example.catscontent.data.remote.breed.BreedDtoItem
import com.example.catscontent.data.remote.cat.CatDtoItem

interface CatRepository {
    suspend fun getBreeds(): List<BreedDtoItem>

    suspend fun getBreedById(
        id: String
    ): List<CatDtoItem>
}