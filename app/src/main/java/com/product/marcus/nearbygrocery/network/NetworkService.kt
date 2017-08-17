package com.product.marcus.nearbygrocery.network

import android.support.v4.util.LruCache
import com.product.marcus.nearbygrocery.models.PlaceResponse

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

import io.reactivex.Observable
import retrofit2.http.Query


/**
 * Created by Marcus on 8/15/2017.
 */
class NetworkService {
    /**
     * Method to return the API interface.
     * @return
     */
    val api: PlacesApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        api = retrofit.create(PlacesApi::class.java)
    }

    fun getAPI(): PlacesApi {
        return api
    }


    /**
     * all the Service alls to use for the retrofit requests.
     */
    interface PlacesApi {
        @GET("maps/api/place/nearbysearch/json")
        fun getGroceryList(@Query("location") location: String,
                           @Query("radius") radius: Int,
                           @Query("type") type: String,
                           @Query("key") key:  String)
                : Observable<PlaceResponse>

    }
    companion object {

        private val baseUrl = "https://maps.googleapis.com/"
    }

}