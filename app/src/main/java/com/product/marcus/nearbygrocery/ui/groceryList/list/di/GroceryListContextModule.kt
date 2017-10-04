package com.product.marcus.nearbygrocery.ui.groceryList.list.di

import com.product.marcus.nearbygrocery.ui.groceryList.list.GroceryListActivity
import dagger.Module
import dagger.Provides

/**
 * Created by Marcus on 9/28/2017.
 */
@Module
class GroceryListContextModule(internal var GroceryListContext: GroceryListActivity) {

    @GroceryListScope
    @Provides
    internal fun provideGroceryListContext(): GroceryListActivity {
        return GroceryListContext
    }


}