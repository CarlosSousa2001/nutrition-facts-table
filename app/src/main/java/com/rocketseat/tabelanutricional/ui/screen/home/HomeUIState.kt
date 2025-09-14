package com.rocketseat.tabelanutricional.ui.screen.home

import com.rocketseat.tabelanutricional.domain.model.HomeContent

data class HomeUIState (
    val isLoading: Boolean = false,
    val homeContent: HomeContent? = null,
    val userName: String? = null
)