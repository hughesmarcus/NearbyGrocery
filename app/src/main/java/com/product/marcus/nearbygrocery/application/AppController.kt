package com.product.marcus.nearbygrocery.application

import android.app.Application
import android.arch.persistence.room.Room
import com.product.marcus.nearbygrocery.database.FoodDatabase

/**
 * Created by Marcus on 8/23/2017.
 */
class AppController : Application() {
    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
        var database: FoodDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        initAppComponent()

    }

    fun getNetComponent(): AppComponent {
        return appComponent
    }

    private fun initAppComponent() {
        AppController.database = Room.databaseBuilder(this, FoodDatabase::class.java, "we-need-db").build()
        appComponent =
                DaggerAppComponent.builder()
                        .appContextModule(AppContextModule(this))
                        .build()
    }
}