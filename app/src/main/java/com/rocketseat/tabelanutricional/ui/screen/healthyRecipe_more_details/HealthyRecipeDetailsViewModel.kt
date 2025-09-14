package com.rocketseat.tabelanutricional.ui.screen.healthyRecipe_more_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rocketseat.tabelanutricional.domain.usecase.GetHealthyRecipeByIdUseCase
import com.rocketseat.tabelanutricional.domain.usecase.IsHealthyRecipeFavorite
import com.rocketseat.tabelanutricional.domain.usecase.UpdateHealthyRecipeIsFavoriteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HealthyRecipeDetailsViewModel(
    private val updateHealthyRecipeIsFavoriteUseCase: UpdateHealthyRecipeIsFavoriteUseCase,
    private val getHealthyRecipeByIdUseCase: GetHealthyRecipeByIdUseCase,
    private val isHealthyRecipeFavorite: IsHealthyRecipeFavorite
) : ViewModel() {

    private val _uiState = MutableStateFlow(HealthyRecipeDetailsUIState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: HealthyRecipeDetailsEvent) {
        when (event) {
            is HealthyRecipeDetailsEvent.FindHealthyRecipeById -> findHealthyRecipeById(event.id)
            is HealthyRecipeDetailsEvent.UpdateIsFavorite -> updateIsFavorite(
                event.id,
                event.isFavorite
            )

            HealthyRecipeDetailsEvent.OnBackPressed -> resetState()
        }
    }

    private fun updateIsFavorite(id: String, favorite: Boolean) {
        viewModelScope.launch {
            updateHealthyRecipeIsFavoriteUseCase(id = id, isFavorite = favorite)
        }

    }
    private fun findHealthyRecipeById(id: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            val healthyRecipe = getHealthyRecipeByIdUseCase(id = id)
            val isFavorite = isHealthyRecipeFavorite(id = id)
            _uiState.update {
                it.copy(
                    isLoading = false,
                    healthyRecipe = healthyRecipe,
                    isFavorite = isFavorite
                )
            }
        }
    }
    private fun resetState() {
        _uiState.update {
            it.copy(
                isLoading = false,
                healthyRecipe = null,
                isFavorite = false
            )
        }
    }


}