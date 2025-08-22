package com.rocketseat.tabelanutricional.domain.model

import com.rocketseat.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.tabelanutricional.data.model.WellnessNews

data class HomeContent(
    val wellnessNewsList: List<WellnessNews>,
    val healthyRecipesList: List<HealthyRecipe>,
)
