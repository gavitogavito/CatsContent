package com.example.catscontent.domain.use_case.get_breeds_by_id

import com.example.catscontent.data.remote.cat.CatDtoItem
import com.example.catscontent.domain.repository.CatRepository
import com.example.catscontent.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBreedsByIdUseCase @Inject constructor(
    private val catRepository: CatRepository
) {
    operator fun invoke(
        breedId: String
    ): Flow<Resource<List<CatDtoItem>>> = flow {
        try {
            emit(Resource.Loading())
            val breed = catRepository.getBreedById(breedId)
            emit(Resource.Success(breed))
        } catch (e: HttpException) {
            // Failure calling the Cat Api
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
            // Failure on Repository (Example: Having no Internet)
            emit(Resource.Error("Couldn't reach remote server"))
        }
    }
}