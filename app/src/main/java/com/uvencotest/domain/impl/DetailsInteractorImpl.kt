package com.uvencotest.domain.impl

import com.uvencotest.domain.api.DetailsInteractor
import com.uvencotest.domain.api.DetailsRepository
import com.uvencotest.domain.entity.ProductDetails

class DetailsInteractorImpl(private val detailsRepository: DetailsRepository): DetailsInteractor {
    override fun saveDetails(productDetails: ProductDetails) {
        detailsRepository.saveDetails(productDetails)
    }

    override fun getDetails(): ProductDetails {
        return detailsRepository.getDetails()
    }
}