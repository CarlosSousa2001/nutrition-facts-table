package com.rocketseat.tabelanutricional.data.datasource.local

import com.rocketseat.tabelanutricional.data.model.HealthyRecipe

interface HealthyRecipeLocalDataSource {

    suspend fun getAllHealthyRecipes(): List<HealthyRecipe>
    suspend fun getHealthyRecipeById(id: String): HealthyRecipe?

    suspend fun checkIsFavorite(id: String): Boolean

    suspend fun updateIdFavorite(id: String, isFavorite: Boolean)
}