package com.rocketseat.tabelanutricional.data.datasource.local

import com.rocketseat.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.tabelanutricional.data.model.mock.mockHealthyRecipes
import java.util.UUID

class MockHealthyRecipeLocalDataSourceImpl: HealthyRecipeLocalDataSource {

    private val healthyRecipeFavoriteIdList = mutableListOf<String>()

    override suspend fun getAllHealthyRecipes(): List<HealthyRecipe> {
        return mockHealthyRecipes
    }

    override suspend fun getHealthyRecipeById(id: String): HealthyRecipe? {
        return mockHealthyRecipes.find { it.id == UUID.fromString(id) }
    }

    override suspend fun checkIsFavorite(id: String): Boolean =
        healthyRecipeFavoriteIdList.contains(id)

    override suspend fun updateIdFavorite(id: String, isFavorite: Boolean) {
        if (isFavorite) healthyRecipeFavoriteIdList.add(id)
        else healthyRecipeFavoriteIdList.remove(id)
    }
}