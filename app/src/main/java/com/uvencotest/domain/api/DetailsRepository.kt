package com.uvencotest.domain.api

import com.uvencotest.domain.entity.ProductDetails

interface DetailsRepository {
    fun saveDetails(productDetails: ProductDetails)
    fun getDetails(): ProductDetails
}