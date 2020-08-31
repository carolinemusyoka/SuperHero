package com.carol.musyoka.superhero.data.repository

import com.carol.musyoka.superhero.data.api.ApiHelper


class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getSuperHeroes() = apiHelper.getSuperHeroes()
}