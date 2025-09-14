package com.rocketseat.tabelanutricional.domain.usecase

import com.rocketseat.tabelanutricional.domain.model.HomeContent
import com.rocketseat.tabelanutricional.domain.repository.HomeContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHomeContextUseCase(
    private val homeContentRepository: HomeContentRepository
) {

    operator fun invoke(): Flow<HomeContent> = flow {
        emit(homeContentRepository.getHomeContent())
    }
}