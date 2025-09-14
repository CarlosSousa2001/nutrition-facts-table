package com.rocketseat.tabelanutricional.domain.usecase

import com.rocketseat.tabelanutricional.domain.repository.HealthyRecipeRepository

class IsHealthyRecipeFavorite(
    private val repository: HealthyRecipeRepository
) {
    suspend operator fun invoke(id: String): Boolean = repository.checkIsFavorite(id = id)
}