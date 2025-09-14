package com.rocketseat.tabelanutricional.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.rocketseat.tabelanutricional.R
import com.rocketseat.tabelanutricional.data.model.HealthyRecipe
import com.rocketseat.tabelanutricional.data.model.WellnessNews
import com.rocketseat.tabelanutricional.data.model.mock.mockHealthyRecipes
import com.rocketseat.tabelanutricional.data.model.mock.mockWellnessNews
import com.rocketseat.tabelanutricional.ui.component.home.HealthyRecipeCard
import com.rocketseat.tabelanutricional.ui.component.home.WelcomeHeader
import com.rocketseat.tabelanutricional.ui.component.home.WellnessNewsCard
import com.rocketseat.tabelanutricional.ui.theme.TabelaNutricionalTheme
import com.rocketseat.tabelanutricional.ui.theme.TabelaNutricionalTheme.sizing
import com.rocketseat.tabelanutricional.ui.theme.Typography

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUIState,
    onEvent: (event: HomeEvent) -> Unit,
    onNavigateToDetails: (selectedHealthyRecipeId: String) -> Unit
) {

    LaunchedEffect(key1 = Unit) {
        onEvent(HomeEvent.OnInit)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.isLoading)
            CircularProgressIndicator()
        else {
            if (uiState.homeContent != null) {
                Column(
                    modifier = Modifier.padding(sizing.md)
                ) {
                    WelcomeHeader(
                        userName = uiState.userName.orEmpty(),
                        hasNewNotification = true,
                    )
                    Spacer(modifier = Modifier.height(sizing.x2l))
                    Text(
                        text = stringResource(R.string.saude_em_foco),
                        style = Typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(sizing.lg))
                    WellnessNewsList(
                        wellnessNewsList = uiState.homeContent.wellnessNewsList,
                        cardWidth = sizing.x5l
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF2F2F2))
                        .padding(sizing.md)
                ) {
                    Text(
                        text = stringResource(R.string.tabela_nutricional),
                        style = Typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(sizing.lg))
                    HealthyRecipeList(
                        healthyRecipeList = uiState.homeContent.healthyRecipesList,
                        onNavigateToDetails = onNavigateToDetails
                    )
                }
            }
        }
    }
}

@Composable
fun WellnessNewsList(
    modifier: Modifier = Modifier,
    wellnessNewsList: List<WellnessNews>,
    cardWidth: Dp
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(sizing.md)
    ) {
        items(items = wellnessNewsList, key = { wellnessNews -> wellnessNews.id }) { wellnessNews ->
            WellnessNewsCard(
                modifier = Modifier.width(cardWidth),
                wellnessNews = wellnessNews,
            )
        }
    }
}

@Composable
fun HealthyRecipeList(
    modifier: Modifier = Modifier,
    healthyRecipeList: List<HealthyRecipe>,
    onNavigateToDetails: (selectedHealthyRecipeId: String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(sizing.md)
    ) {
        items(
            items = healthyRecipeList,
            key = { healthyRecipe -> healthyRecipe.id }) { healthyRecipe ->
            HealthyRecipeCard(
                healthyRecipe = healthyRecipe,
                onClick = { selectedHealthyRecipeId ->
                    onNavigateToDetails(selectedHealthyRecipeId)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    TabelaNutricionalTheme {
        HomeScreen(
            uiState = HomeUIState(),
            onEvent = {},
            onNavigateToDetails = {}
        )
    }
}