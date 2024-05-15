package com.uvencotest.domain.entity

data class ProductDetails(
    val name: String = "Кофе амаретто",
    val price: Int = 199,
    val volume: Float = 0.33f,
    val isFree: Boolean = false,
    val imageOption: ImageSource = ImageSource.CAPPUCCINO
) {
    enum class ImageSource {
        CAPPUCCINO,
        AMERICANO
    }
}
