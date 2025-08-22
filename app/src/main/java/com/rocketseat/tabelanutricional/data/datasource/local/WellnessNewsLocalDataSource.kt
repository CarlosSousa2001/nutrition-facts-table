package com.rocketseat.tabelanutricional.data.datasource.local

import com.rocketseat.tabelanutricional.data.model.WellnessNews

interface WellnessNewsLocalDataSource {

    suspend fun getAllWellnessNews(): List<WellnessNews>
}