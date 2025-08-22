package com.rocketseat.tabelanutricional.data.datasource.local

import com.rocketseat.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.tabelanutricional.data.model.mock.mockHealthyRecipes

class MockHealthyRecipeLocalDataSourceImpl: HealthyRecipeLocalDataSource {
    override suspend fun getAllHealthyRecipes(): List<HealthyRecipe> {
        return mockHealthyRecipes
    }
}