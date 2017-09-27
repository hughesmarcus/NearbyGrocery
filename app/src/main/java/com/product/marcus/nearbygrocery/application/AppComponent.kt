package com.product.marcus.nearbygrocery.application

import android.content.Context
import com.product.marcus.nearbygrocery.network.PlacesApi
import dagger.Component
import dagger.Module
import dagger.Provides

/**
 * Created by Marcus on 8/23/2017.
 */
@AppScope
@Component(modules = arrayOf(NetworkModule::class, AppContextModule::class, PlacesApiServiceModule::class))
interface AppComponent {


    @Module
    class ApplicationModule(val context: Context) {
        @AppScope
        @Provides
        fun context(): Context = context


    }
}

