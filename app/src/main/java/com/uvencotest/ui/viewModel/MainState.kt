package com.uvencotest.ui.viewModel

import com.uvencotest.domain.entity.ProductDetails

sealed interface MainState {
    data object Loading: MainState
    data class Content(val products: List<ProductDetails>): MainState
}