package com.rocketseat.tabelanutricional.ui.screen.healthyRecipe_more_details

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rocketseat.tabelanutricional.R
import com.rocketseat.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.tabelanutricional.data.model.mock.mockHealthyRecipes
import com.rocketseat.tabelanutricional.ui.component.healthy_recipe_more_details.HealthyRecipeNutrientInfo
import com.rocketseat.tabelanutricional.ui.theme.SurfaceElement
import com.rocketseat.tabelanutricional.ui.theme.TabelaNutricionalTheme
import com.rocketseat.tabelanutricional.ui.theme.TabelaNutricionalTheme.sizing
import com.rocketseat.tabelanutricional.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthyRecipeMoreDetails(
    modifier: Modifier = Modifier,
    sheetState: SheetState,
    healthyRecipe: HealthyRecipe,
    onDismiss: () -> Unit
) {

    val isPreview = LocalInspectionMode.current

    LaunchedEffect(key1 = Unit) {
        if (isPreview) sheetState.expand()
    }

    ModalBottomSheet(
        modifier = modifier,
        sheetState = sheetState,
        contentColor = MaterialTheme.colorScheme.onBackground,
        onDismissRequest = { },
        dragHandle = {
            Box(
                modifier = Modifier
                    .padding(sizing.md)
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth(0.2f)
                        .height(sizing.sm)
                ) {
                    drawRoundRect(
                        color = SurfaceElement,
                        cornerRadius = CornerRadius(x = 8.dp.toPx(), y = 8.dp.toPx())
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = sizing.md)
                .padding(bottom = sizing.lg),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(sizing.md)
        ) {
            Text(
                text = stringResource(id = R.string.mais_detalhes),
                style = Typography.headlineMedium
            )

            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.calories
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.proteins
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.carbohydrates
            )

            HealthyRecipeNutrientInfo(
                isSubNutrient = true,
                nutrient = healthyRecipe.fiber
            )
            HealthyRecipeNutrientInfo(
                isSubNutrient = true,
                nutrient = healthyRecipe.sugar
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.fat
            )
            HealthyRecipeNutrientInfo(
                isSubNutrient = true,
                nutrient = healthyRecipe.saturatedFat
            )
            HealthyRecipeNutrientInfo(
                isSubNutrient = true,
                nutrient = healthyRecipe.transFat
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.cholesterol
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.sodium
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.potassium
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.calcium
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.iron
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.magnesium
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.vitaminC
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.vitaminD
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.vitaminB6
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun HealthyRecipeMoreDetailsPreview() {
    TabelaNutricionalTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(SurfaceElement)
        ) {
            HealthyRecipeMoreDetails(
                sheetState = rememberModalBottomSheetState(),
                healthyRecipe = mockHealthyRecipes.first(),
                onDismiss = {}
            )
        }
    }
}