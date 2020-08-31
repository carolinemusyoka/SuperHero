package com.carol.musyoka.superhero.data.api


import com.carol.musyoka.superhero.data.model.Hero
import retrofit2.http.GET

interface ApiService {
    @GET("all.json")
    suspend fun getSuperHeroes(): List<Hero>
}