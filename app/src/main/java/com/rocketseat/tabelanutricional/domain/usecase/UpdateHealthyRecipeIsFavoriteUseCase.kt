package com.rocketseat.tabelanutricional.domain.usecase

import com.rocketseat.tabelanutricional.domain.repository.HealthyRecipeRepository

class UpdateHealthyRecipeIsFavoriteUseCase (
    private val repository: HealthyRecipeRepository
) {
    suspend operator fun invoke(id: String, isFavorite: Boolean) = repository.updateIdFavorite(id = id, isFavorite = isFavorite)
}