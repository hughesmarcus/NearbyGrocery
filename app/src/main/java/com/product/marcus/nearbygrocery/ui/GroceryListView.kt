package com.product.marcus.nearbygrocery.ui

import android.view.View
import com.product.marcus.nearbygrocery.models.PlaceResponse

/**
 * Created by Marcus on 8/15/2017.
 */
interface GroceryListView {

   fun showWait()
    fun removeWait()

    fun onFailure(appErrorMessage: String)
    fun getGroceryListSuccess(placeResponse: PlaceResponse)
}