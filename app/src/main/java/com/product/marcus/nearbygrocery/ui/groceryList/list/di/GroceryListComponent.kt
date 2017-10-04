package com.product.marcus.nearbygrocery.ui.groceryList.list.di

import com.product.marcus.nearbygrocery.ui.groceryList.list.GroceryListActivity
import com.product.marcus.nearbygrocery.application.AppComponent
import dagger.Component


/**
 * Created by Marcus on 9/28/2017.
 */
@GroceryListScope
@Component(modules = arrayOf(GroceryListContextModule::class, GroceryListModule::class), dependencies = arrayOf(AppComponent::class))
public interface GroceryListComponent {

    fun inject(activity: GroceryListActivity)
}


