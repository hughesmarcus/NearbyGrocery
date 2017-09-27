package com.product.marcus.nearbygrocery.application

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Marcus on 8/23/2017.
 */
@Module
class AppContextModule(private val context: Context) {

    @AppScope
    @Provides
    internal fun provideAppContext(): Context {
        return context
    }

}