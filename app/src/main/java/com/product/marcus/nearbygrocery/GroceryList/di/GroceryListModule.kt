package com.product.marcus.nearbygrocery.GroceryList.di

import com.product.marcus.nearbygrocery.GroceryList.list.GroceryListPresenter
import com.product.marcus.nearbygrocery.application.AppController
import dagger.Module
import dagger.Provides

/**
 * Created by Marcus on 9/28/2017.
 */
@Module
class GroceryListModule {
    @EditItemScope
    @Provides
    fun providePresenter(): GroceryListPresenter {
        //val compositeSubscription = CompositeSubscription()
        return GroceryListPresenter(AppController.database!!.itemDao())
    }


}