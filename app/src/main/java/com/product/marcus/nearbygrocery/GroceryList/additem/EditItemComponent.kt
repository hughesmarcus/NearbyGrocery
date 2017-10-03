package com.product.marcus.nearbygrocery.GroceryList.di

import com.product.marcus.nearbygrocery.GroceryList.additem.EditItemActivity
import com.product.marcus.nearbygrocery.GroceryList.additem.EditItemContextModule
import com.product.marcus.nearbygrocery.GroceryList.additem.EditItemModule
import com.product.marcus.nearbygrocery.application.AppComponent
import dagger.Component


/**
 * Created by Marcus on 9/28/2017.
 */
@EditItemScope
@Component(modules = arrayOf(EditItemContextModule::class, EditItemModule::class), dependencies = arrayOf(AppComponent::class))
public interface EditItemComponent {

    fun inject(activity: EditItemActivity)
}


