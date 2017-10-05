package com.product.marcus.nearbygrocery.ui.groceryList.list.di

import com.product.marcus.nearbygrocery.ui.groceryList.list.GroceryListPresenter
import com.product.marcus.nearbygrocery.application.AppController
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Marcus on 9/28/2017.
 */
@Module
class GroceryListModule {
    @GroceryListScope
    @Provides
    fun providePresenter(): GroceryListPresenter {
        val compositeDisposable = CompositeDisposable()
        return GroceryListPresenter(AppController.database!!.itemDao(), compositeDisposable)
    }


}