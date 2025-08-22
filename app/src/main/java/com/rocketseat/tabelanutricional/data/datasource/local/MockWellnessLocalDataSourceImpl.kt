package com.rocketseat.tabelanutricional.data.datasource.local

import com.rocketseat.tabelanutricional.data.model.WellnessNews
import com.rocketseat.tabelanutricional.data.model.mock.mockWellnessNews

class MockWellnessLocalDataSourceImpl: WellnessNewsLocalDataSource {
    override suspend fun getAllWellnessNews(): List<WellnessNews> {
        return mockWellnessNews
    }
}