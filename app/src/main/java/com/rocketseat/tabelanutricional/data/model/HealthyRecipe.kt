package com.rocketseat.tabelanutricional.data.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class HealthyRecipe(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    @DrawableRes val imageRes: Int,
    val calories: Float,
    val proteins: Float,
    val carbohydrates: Float,
    val sugar: Float,
    val fat: Float,
    val totalPortionInGrams: Int
)