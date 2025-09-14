package com.rocketseat.tabelanutricional.ui.screen.healthy_recipe_details

import com.rocketseat.tabelanutricional.data.model.HealthyRecipe

data class HealthyRecipeDetailsUIState (
    val isLoading: Boolean = false,
    val healthyRecipe: HealthyRecipe? = null,
    val isFavorite: Boolean = false,
)
