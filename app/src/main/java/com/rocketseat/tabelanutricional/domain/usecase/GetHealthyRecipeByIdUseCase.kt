package com.rocketseat.tabelanutricional.domain.usecase

import com.rocketseat.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.tabelanutricional.domain.repository.HealthyRecipeRepository

class GetHealthyRecipeByIdUseCase(
    private val repository: HealthyRecipeRepository
) {
    suspend operator fun invoke(id: String): HealthyRecipe? = repository.getHealthyRecipeById(id = id)
}