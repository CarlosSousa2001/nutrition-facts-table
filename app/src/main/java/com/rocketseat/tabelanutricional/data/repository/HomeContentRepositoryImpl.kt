package com.rocketseat.tabelanutricional.data.repository

import com.rocketseat.tabelanutricional.data.datasource.local.HealthyRecipeLocalDataSource
import com.rocketseat.tabelanutricional.data.datasource.local.WellnessNewsLocalDataSource
import com.rocketseat.tabelanutricional.domain.model.HomeContent
import com.rocketseat.tabelanutricional.domain.repository.HomeContentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class HomeContentRepositoryImpl(
    private val healthyRecipeLocalDataSource: HealthyRecipeLocalDataSource,
    private val wellnessNewsLocalDataSource: WellnessNewsLocalDataSource
) : HomeContentRepository {
    override suspend fun getHomeContent(): HomeContent =
        withContext(Dispatchers.Default) {
            val healthyRecipeList = healthyRecipeLocalDataSource.getAllHealthyRecipes()
            val wellnessNewsList = wellnessNewsLocalDataSource.getAllWellnessNews()

            delay(1_000)

            return@withContext HomeContent(
                wellnessNewsList = wellnessNewsList,
                healthyRecipesList = healthyRecipeList
            )
        }
}