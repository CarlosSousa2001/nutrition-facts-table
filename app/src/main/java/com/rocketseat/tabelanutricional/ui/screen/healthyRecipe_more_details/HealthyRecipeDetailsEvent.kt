package com.rocketseat.tabelanutricional.ui.screen.healthyRecipe_more_details

sealed interface HealthyRecipeDetailsEvent {
    data class FindHealthyRecipeById(val id: String): HealthyRecipeDetailsEvent
    data class UpdateIsFavorite(val id: String, val isFavorite: Boolean): HealthyRecipeDetailsEvent
    data object OnBackPressed: HealthyRecipeDetailsEvent
}