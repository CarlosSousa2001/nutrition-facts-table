package com.rocketseat.tabelanutricional.domain.repository

import com.rocketseat.tabelanutricional.data.model.HealthyRecipe

interface HealthyRecipeRepository {

    suspend fun getHealthyRecipeById(id: String): HealthyRecipe?
}