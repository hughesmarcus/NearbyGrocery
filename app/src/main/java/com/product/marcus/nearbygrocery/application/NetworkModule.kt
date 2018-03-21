package com.product.marcus.nearbygrocery.application

import android.content.Context
import retrofit2.converter.gson.GsonConverterFactory
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import okhttp3.Cache

import okhttp3.logging.HttpLoggingInterceptor
import java.io.File


/**
 * Created by Marcus on 8/23/2017.
 */
@Module
class NetworkModule {

    @AppScope
    @Provides
    internal fun provideHttpClient(logger: HttpLoggingInterceptor, cache: Cache): OkHttpClient {

        val builder = OkHttpClient().newBuilder()
        builder.addInterceptor(logger)
        builder.cache(cache)
        return builder.build()
    }

    @AppScope
    @Provides
    internal fun provideInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    internal fun provideCache(file: File): Cache {
        return Cache(file, 10 * 10 * 1000)
    }

    @AppScope
    @Provides
    internal fun provideCacheFile(context: Context): File {
        return context.getFilesDir()
    }

    @AppScope
    @Provides
    internal fun provideRxAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }


    @Provides
    internal fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}