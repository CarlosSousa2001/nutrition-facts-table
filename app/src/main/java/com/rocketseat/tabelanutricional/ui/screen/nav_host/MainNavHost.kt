package com.rocketseat.tabelanutricional.ui.screen.nav_host

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rocketseat.tabelanutricional.core.navigation.UIRoute
import com.rocketseat.tabelanutricional.data.model.mock.mockHealthyRecipes
import com.rocketseat.tabelanutricional.ui.screen.healthy_recipe_details.HealthyRecipeDetailsScreen
import com.rocketseat.tabelanutricional.ui.screen.ui.HomeScreen

@Composable
fun MainNavHost(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController, startDestination = UIRoute.Home
    ) {
        composable<UIRoute.Home> {
            HomeScreen(
                onNavigateToDetails = { healthyRecipeId ->
                    navController.navigate(UIRoute.HealthyRecipeDetails(healthyRecipeId = healthyRecipeId))
                })
        }

        composable<UIRoute.HealthyRecipeDetails> {
            val healthyRecipeId = it.arguments?.getString("healthyRecipeId")

            healthyRecipeId?.let {
                val healthyRecipe =
                    mockHealthyRecipes.find { healthyRecipe -> healthyRecipeId == healthyRecipe.id.toString() }
                if (healthyRecipe == null) return@composable

                HealthyRecipeDetailsScreen(
                    healthyRecipe = healthyRecipe,
                    onNavigateBack = { navController.popBackStack() },
                    onClickFavorite = {}
                )
            }
        }
    }
}