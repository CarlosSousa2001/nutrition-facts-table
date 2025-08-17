package com.rocketseat.tabelanutricional.ui.component.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.rocketseat.tabelanutricional.R
import com.rocketseat.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.tabelanutricional.ui.theme.TabelaNutricionalTheme
import com.rocketseat.tabelanutricional.ui.theme.TabelaNutricionalTheme.sizing
import com.rocketseat.tabelanutricional.ui.theme.Typography
import java.util.UUID

@Composable
fun HealthyRecipeCard(
    modifier: Modifier = Modifier,
    healthyRecipe: HealthyRecipe
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .size(sizing.x2l)
                .clip(shape = RoundedCornerShape(size = sizing.md)),
            painter = painterResource(id = healthyRecipe.imageRes),
            contentDescription = stringResource(id = R.string.imagem_item_tabela_nutricional)
        )
        Spacer(modifier = Modifier.width(sizing.md))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(sizing.sm)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = healthyRecipe.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.headlineMedium
                )

                Text(
                    text = stringResource(R.string.valor_kcal, healthyRecipe.calories),
                    style = Typography.bodyLarge
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(
                    R.string.g_proteinas_g_carboidratos_da_receita,
                    healthyRecipe.proteins,
                    healthyRecipe.carbohydrates
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = Typography.bodyLarge.copy(MaterialTheme.colorScheme.secondary)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF2F2F2)
@Composable
private fun HealthyRecipeCardPreview() {
    TabelaNutricionalTheme {
        Column(
            modifier = Modifier.padding(sizing.md),
            verticalArrangement = Arrangement.spacedBy(sizing.md)
        ) {
            repeat(5) {

                HealthyRecipeCard(
                    healthyRecipe = HealthyRecipe(
                        name = "Salada de Frutas",
                        imageRes = R.drawable.img_assorted_salad,
                        calories = 221.15f,
                        proteins = 13.2f,
                        carbohydrates = 22.80f,
                        sugar = 4.88f,
                        fat = 5.18f,
                        totalPortionInGrams = 240
                    ),
                )
            }
        }
    }
}