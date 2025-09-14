package com.rocketseat.tabelanutricional.domain.repository

import com.rocketseat.tabelanutricional.data.model.HealthyRecipe

interface HealthyRecipeRepository {
    suspend fun getHealthyRecipeById(id: String): HealthyRecipe?

    suspend fun checkIsFavorite(id: String): Boolean

    suspend fun updateIdFavorite(id: String, isFavorite: Boolean)
}