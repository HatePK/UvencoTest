package com.uvencotest.data.api

import com.uvencotest.domain.entity.ProductDetails

interface LocalClient {
    fun saveDetails(details: ProductDetails)
    fun getDetails(): ProductDetails
}