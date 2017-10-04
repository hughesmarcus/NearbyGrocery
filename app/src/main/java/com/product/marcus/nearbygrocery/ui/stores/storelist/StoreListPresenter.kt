package com.product.marcus.nearbygrocery.ui.stores.storelist

/**
 * Created by Marcus on 8/15/2017.
 */
interface StoreListPresenter {
    fun onDestroy()
    fun getGroceryLocations(lat: Double, lon: Double)
    fun getLocation()
}