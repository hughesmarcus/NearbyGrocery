package com.product.marcus.nearbygrocery.GroceryList.di

import android.arch.persistence.room.Room
import android.content.Context
import com.product.marcus.nearbygrocery.GroceryList.list.GroceryListActivity
import com.product.marcus.nearbygrocery.application.AppComponent
import com.product.marcus.nearbygrocery.application.AppScope
import com.product.marcus.nearbygrocery.database.FoodDatabase
import dagger.Component
import dagger.Provides


/**
 * Created by Marcus on 9/28/2017.
 */
@GroceryListScope
@Component(modules = arrayOf(GroceryListContextModule::class, GroceryListModule::class), dependencies = arrayOf(AppComponent::class))
public interface GroceryListComponent {

    fun inject(activity: GroceryListActivity)
}


