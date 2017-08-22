package com.product.marcus.nearbygrocery.stores.storelist

/**
 * Created by Marcus on 8/15/2017.
 */
interface StoreListPresenter {
    fun rxUnSubscribe()
    fun getGroceryLocations(lat: Double, lon: Double)
    fun getLocation()
}