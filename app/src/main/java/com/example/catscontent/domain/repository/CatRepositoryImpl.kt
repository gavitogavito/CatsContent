package com.example.catscontent.domain.repository

import com.example.catscontent.data.remote.CatApi
import com.example.catscontent.data.remote.breed.BreedDtoItem
import com.example.catscontent.data.remote.cat.CatDtoItem
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val catApi: CatApi
) : CatRepository {

    override suspend fun getBreeds(): List<BreedDtoItem> {
        return catApi.getBreeds()
    }

    override suspend fun getBreedById(id: String): List<CatDtoItem> {
        return catApi.getBreedById(id)
    }
}