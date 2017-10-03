package com.product.marcus.nearbygrocery.GroceryList.additem

import com.product.marcus.nearbygrocery.GroceryList.di.EditItemScope
import com.product.marcus.nearbygrocery.GroceryList.list.GroceryListActivity
import dagger.Module
import dagger.Provides


@Module
class EditItemContextModule(internal var EditItemContext: EditItemActivity) {

    @EditItemScope
    @Provides
    internal fun provideEditItemContext(): EditItemActivity {
        return EditItemContext
    }


}