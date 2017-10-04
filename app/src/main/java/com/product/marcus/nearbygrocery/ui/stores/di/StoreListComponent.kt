package com.product.marcus.nearbygrocery.ui.stores.di

import com.product.marcus.nearbygrocery.application.AppComponent
import com.product.marcus.nearbygrocery.ui.stores.storelist.StoreListActivity
import dagger.Component

/**
 * Created by Marcus on 10/4/2017.
 */
@StoreListScope
@Component(modules = arrayOf(StoreListContextModule::class, StoreListModule::class), dependencies = arrayOf(AppComponent::class))
public interface StoreListComponent {

    fun inject(activity: StoreListActivity)
}


