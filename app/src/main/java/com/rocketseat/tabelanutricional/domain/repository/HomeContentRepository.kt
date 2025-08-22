package com.rocketseat.tabelanutricional.domain.repository

import com.rocketseat.tabelanutricional.domain.model.HomeContent

interface HomeContentRepository {

    suspend fun getHomeContent():  HomeContent
}