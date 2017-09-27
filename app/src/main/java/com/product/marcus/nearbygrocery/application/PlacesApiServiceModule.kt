package com.product.marcus.nearbygrocery.application

import com.product.marcus.nearbygrocery.network.PlacesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


/**
 * Created by Marcus on 8/23/2017.
 */
@Module
class PlacesApiServiceModule {
    private val BASE_URL = "https://maps.googleapis.com/"
    @AppScope
    @Provides
    fun provideApiService(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): PlacesApi {
        val retrofit = Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).addCallAdapterFactory(rxAdapter).build()

        return retrofit.create<PlacesApi>(PlacesApi::class.java!!)
    }

}