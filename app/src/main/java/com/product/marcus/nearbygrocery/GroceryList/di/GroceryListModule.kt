package com.product.marcus.nearbygrocery.GroceryList.di

import android.arch.persistence.room.Room
import android.content.Context
import com.product.marcus.nearbygrocery.GroceryList.list.GroceryListActivity
import com.product.marcus.nearbygrocery.GroceryList.list.GroceryListPresenter
import com.product.marcus.nearbygrocery.GroceryList.list.GroceryListView
import com.product.marcus.nearbygrocery.application.AppComponent
import com.product.marcus.nearbygrocery.application.AppController
import com.product.marcus.nearbygrocery.database.FoodDatabase
import com.product.marcus.nearbygrocery.database.ItemDao
import dagger.Module
import dagger.Provides

/**
 * Created by Marcus on 9/28/2017.
 */
@Module
class GroceryListModule {
    @GroceryListScope
    @Provides
    fun providePresenter(): GroceryListPresenter {
        //val compositeSubscription = CompositeSubscription()
        return GroceryListPresenter(AppController.database!!.itemDao())
    }


}