package com.product.marcus.nearbygrocery.ui

/**
 * Created by Marcus on 8/15/2017.
 */
interface GroceryListPresenter {
    fun rxUnSubscribe()
    fun getGroceryLocations( lat:Double, lon:Double )
    fun getLocation()
}