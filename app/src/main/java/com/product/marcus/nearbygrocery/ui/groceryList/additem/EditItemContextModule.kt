package com.product.marcus.nearbygrocery.ui.groceryList.additem

import com.product.marcus.nearbygrocery.ui.groceryList.list.di.EditItemScope
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