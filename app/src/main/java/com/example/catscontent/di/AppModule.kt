package com.example.catscontent.di

import com.example.catscontent.common.Constants
import com.example.catscontent.data.remote.CatApi
import com.example.catscontent.domain.repository.CatRepository
import com.example.catscontent.domain.repository.CatRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCatApi(): CatApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCatRepository(api: CatApi): CatRepository {
        return CatRepositoryImpl(api)
    }
}