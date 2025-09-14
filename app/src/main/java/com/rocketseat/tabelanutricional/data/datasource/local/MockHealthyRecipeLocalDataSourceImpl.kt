package com.rocketseat.tabelanutricional.data.datasource.local

import com.rocketseat.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.tabelanutricional.data.model.mock.mockHealthyRecipes
import java.util.UUID

class MockHealthyRecipeLocalDataSourceImpl: HealthyRecipeLocalDataSource {
    override suspend fun getAllHealthyRecipes(): List<HealthyRecipe> {
        return mockHealthyRecipes
    }

    override suspend fun getHealthyRecipeById(id: String): HealthyRecipe? {
        return mockHealthyRecipes.find { it.id == UUID.fromString(id) }
    }
}