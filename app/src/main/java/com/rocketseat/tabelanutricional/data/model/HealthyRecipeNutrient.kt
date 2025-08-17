package com.rocketseat.tabelanutricional.data.model

import androidx.annotation.StringRes

data class HealthyRecipeNutrient(
    val value: Float,
    val unit: NutrientUnit,
    @StringRes val name: Int,
)
