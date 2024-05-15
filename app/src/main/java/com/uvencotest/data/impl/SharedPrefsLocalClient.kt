package com.uvencotest.data.impl

import android.content.Context
import com.google.gson.Gson
import com.uvencotest.data.api.LocalClient
import com.uvencotest.domain.entity.ProductDetails

class SharedPrefsLocalClient(private val context: Context): LocalClient {
    private val sharedPreferences = context.getSharedPreferences("uvenco", Context.MODE_PRIVATE)
    private val gson = Gson()

    override fun saveDetails(details: ProductDetails) {
        val detailsGson = gson.toJson(details)
        sharedPreferences.edit().putString("details", detailsGson).apply()
    }

    override fun getDetails(): ProductDetails {
        val detailsGson = sharedPreferences.getString("details", "")

        return if (detailsGson == "") {
            ProductDetails()
        } else {
            gson.fromJson(detailsGson, ProductDetails::class.java)
        }
    }
}