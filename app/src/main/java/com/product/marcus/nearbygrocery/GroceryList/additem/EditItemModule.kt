package com.product.marcus.nearbygrocery.GroceryList.additem

import com.product.marcus.nearbygrocery.GroceryList.di.EditItemScope
import com.product.marcus.nearbygrocery.application.AppController
import dagger.Module
import dagger.Provides


@Module
class EditItemModule {
    @EditItemScope
    @Provides
    fun providePresenter(): EditItemPresenter {
        //val compositeSubscription = CompositeSubscription()
        return EditItemPresenter(AppController.database!!.itemDao())
    }


}