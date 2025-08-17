package com.rocketseat.tabelanutricional.ui.component.healthy_recipe_more_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rocketseat.tabelanutricional.R
import com.rocketseat.tabelanutricional.data.model.NutrientUnit
import com.rocketseat.tabelanutricional.ui.theme.TabelaNutricionalTheme
import com.rocketseat.tabelanutricional.ui.theme.TabelaNutricionalTheme.sizing
import com.rocketseat.tabelanutricional.ui.theme.Typography


@Composable
fun HealthyRecipeNutrientInfo(
    modifier: Modifier = Modifier,
    isSubNutrient: Boolean = false,
    name: String,
    value: Float,
    unit: NutrientUnit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = if (isSubNutrient) sizing.md else sizing.x0),
            text = name,
            style = if (isSubNutrient) Typography.bodyMedium else Typography.headlineSmall
        )
        Text(
            text = stringResource(R.string.valor_nutrient, value, unit.symbol),
            style = Typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HealthyRecipeNutrientInfoPreview() {
    Column {
        TabelaNutricionalTheme {
            HealthyRecipeNutrientInfo(
                modifier = Modifier.padding(16.dp),
                name = "Energia",
                value = 25f,
                unit = NutrientUnit.GRAM
            )
            HealthyRecipeNutrientInfo(
                modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 16.dp),
                isSubNutrient = true,
                name = "Fibra alimentar",
                value = 5.83f,
                unit = NutrientUnit.GRAM
            )
        }
    }
}