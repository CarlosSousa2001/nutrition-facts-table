package com.rocketseat.tabelanutricional.core.di

import com.rocketseat.tabelanutricional.data.datasource.local.HealthyRecipeLocalDataSource
import com.rocketseat.tabelanutricional.data.datasource.local.MockHealthyRecipeLocalDataSourceImpl
import com.rocketseat.tabelanutricional.data.datasource.local.MockWellnessLocalDataSourceImpl
import com.rocketseat.tabelanutricional.data.datasource.local.WellnessNewsLocalDataSource
import com.rocketseat.tabelanutricional.data.repository.HealthyRecipeRepositoryImpl
import com.rocketseat.tabelanutricional.data.repository.HomeContentRepositoryImpl
import com.rocketseat.tabelanutricional.domain.repository.HealthyRecipeRepository
import com.rocketseat.tabelanutricional.domain.repository.HomeContentRepository
import com.rocketseat.tabelanutricional.domain.usecase.GetHealthyRecipeByIdUseCase
import com.rocketseat.tabelanutricional.domain.usecase.GetHomeContextUseCase
import com.rocketseat.tabelanutricional.domain.usecase.IsHealthyRecipeFavorite
import com.rocketseat.tabelanutricional.domain.usecase.UpdateHealthyRecipeIsFavoriteUseCase
import com.rocketseat.tabelanutricional.ui.screen.healthy_recipe_details.HealthyRecipeDetailsViewModel
import com.rocketseat.tabelanutricional.ui.screen.home.HomeViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object AppModules {

    val uiModule = module {
        viewModelOf(::HomeViewModel)
        viewModelOf(::HealthyRecipeDetailsViewModel)
    }

    val domainModule = module {
        factory { GetHomeContextUseCase(get()) }
        factory { GetHealthyRecipeByIdUseCase(get()) }
        factory { IsHealthyRecipeFavorite(get()) }
        factory { UpdateHealthyRecipeIsFavoriteUseCase(get()) }
    }

    val dataModule = module {
        singleOf(::MockHealthyRecipeLocalDataSourceImpl) { bind<HealthyRecipeLocalDataSource>() }
        singleOf(::MockWellnessLocalDataSourceImpl) { bind<WellnessNewsLocalDataSource>() }
        singleOf(::HomeContentRepositoryImpl) { bind<HomeContentRepository>() }
        singleOf(::HealthyRecipeRepositoryImpl) { bind<HealthyRecipeRepository>() }
    }

}