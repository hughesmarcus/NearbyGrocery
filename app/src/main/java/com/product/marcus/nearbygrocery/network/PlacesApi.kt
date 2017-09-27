package com.product.marcus.nearbygrocery.network

import com.product.marcus.nearbygrocery.models.PlaceResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by Marcus on 8/15/2017.
 */
interface PlacesApi {
    @GET("maps/api/place/nearbysearch/json")
    fun getGroceryList(@Query("location") location: String,
                       @Query("radius") radius: Int,
                       @Query("type") type: String,
                       @Query("key") key: String)
            : Observable<PlaceResponse>

}