package com.product.marcus.nearbygrocery.ui.groceryList.additem

import com.product.marcus.nearbygrocery.ui.groceryList.list.di.EditItemScope
import com.product.marcus.nearbygrocery.application.AppController
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class EditItemModule {
    @EditItemScope
    @Provides
    fun providePresenter(): EditItemPresenter {
        val compositeDisposable = CompositeDisposable()
        return EditItemPresenter(AppController.database!!.itemDao(), compositeDisposable)
    }


}