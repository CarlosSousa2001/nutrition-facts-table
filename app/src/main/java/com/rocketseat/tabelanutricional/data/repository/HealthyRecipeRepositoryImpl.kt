package com.rocketseat.tabelanutricional.data.repository

import com.rocketseat.tabelanutricional.data.datasource.local.HealthyRecipeLocalDataSource
import com.rocketseat.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.tabelanutricional.domain.repository.HealthyRecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HealthyRecipeRepositoryImpl(
    private val localDataSource: HealthyRecipeLocalDataSource
) : HealthyRecipeRepository {
    override suspend fun getHealthyRecipeById(id: String): HealthyRecipe? =
        withContext(Dispatchers.IO) {
            localDataSource.getHealthyRecipeById(id = id)
        }
}