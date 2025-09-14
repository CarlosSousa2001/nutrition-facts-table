package com.rocketseat.tabelanutricional.data.datasource.local

import com.rocketseat.tabelanutricional.data.model.HealthyRecipe

interface HealthyRecipeLocalDataSource {

    suspend fun getAllHealthyRecipes(): List<HealthyRecipe>
    suspend fun getHealthyRecipeById(id: String): HealthyRecipe?

}