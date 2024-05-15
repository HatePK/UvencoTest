package com.uvencotest.data

import com.uvencotest.data.api.LocalClient
import com.uvencotest.domain.api.DetailsRepository
import com.uvencotest.domain.entity.ProductDetails

class DetailsRepositoryImpl(private val localClient: LocalClient):DetailsRepository {
    override fun saveDetails(productDetails: ProductDetails) {
        localClient.saveDetails(productDetails)
    }

    override fun getDetails(): ProductDetails {
        return localClient.getDetails()
    }
}