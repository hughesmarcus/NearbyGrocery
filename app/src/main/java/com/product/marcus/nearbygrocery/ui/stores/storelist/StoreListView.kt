package com.product.marcus.nearbygrocery.ui.stores.storelist

import com.product.marcus.nearbygrocery.models.PlaceResponse

/**
 * Created by Marcus on 8/15/2017.
 */
interface StoreListView {

    fun showWait()
    fun removeWait()

    fun onFailure(appErrorMessage: String)
    fun getGroceryListSuccess(placeResponse: PlaceResponse)
}