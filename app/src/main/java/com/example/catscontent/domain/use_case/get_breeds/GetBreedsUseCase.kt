package com.example.catscontent.domain.use_case.get_breeds

import com.example.catscontent.data.remote.breed.Breed
import com.example.catscontent.data.remote.breed.toBreed
import com.example.catscontent.domain.repository.CatRepository
import com.example.catscontent.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBreedsUseCase @Inject constructor(
    private val catRepository: CatRepository
) {
    operator fun invoke(): Flow<Resource<List<Breed>>> = flow {
        try {
            emit(Resource.Loading())
            val breeds = catRepository.getBreeds().map { it.toBreed() }
            emit(Resource.Success(breeds))
        } catch (e: HttpException) {
            // Failure calling the Cat Api
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
            // Failure on Repository (Example: Having no Internet)
            emit(Resource.Error("Couldn't reach remote server"))
        }
    }
}