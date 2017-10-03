package com.product.marcus.nearbygrocery.GroceryList.di

import com.product.marcus.nearbygrocery.GroceryList.list.GroceryListActivity
import com.product.marcus.nearbygrocery.application.AppComponent
import dagger.Component


/**
 * Created by Marcus on 9/28/2017.
 */
@EditItemScope
@Component(modules = arrayOf(GroceryListContextModule::class, GroceryListModule::class), dependencies = arrayOf(AppComponent::class))
public interface GroceryListComponent {

    fun inject(activity: GroceryListActivity)
}


