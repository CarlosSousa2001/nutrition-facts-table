package com.rocketseat.tabelanutricional.core.di

import com.rocketseat.tabelanutricional.data.datasource.local.HealthyRecipeLocalDataSource
import com.rocketseat.tabelanutricional.data.datasource.local.MockHealthyRecipeLocalDataSourceImpl
import com.rocketseat.tabelanutricional.data.datasource.local.MockWellnessLocalDataSourceImpl
import com.rocketseat.tabelanutricional.data.datasource.local.WellnessNewsLocalDataSource
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object AppModules {

    val uiModule = module {

    }

    val domainModule = module {

    }

    val dataModule = module {
        singleOf(::MockHealthyRecipeLocalDataSourceImpl) { bind<HealthyRecipeLocalDataSource>() }
        singleOf(::MockWellnessLocalDataSourceImpl) { bind<WellnessNewsLocalDataSource>() }
    }

}