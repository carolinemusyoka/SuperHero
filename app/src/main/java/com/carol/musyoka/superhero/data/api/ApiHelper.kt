package com.carol.musyoka.superhero.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getSuperHeroes() = apiService.getSuperHeroes()
}