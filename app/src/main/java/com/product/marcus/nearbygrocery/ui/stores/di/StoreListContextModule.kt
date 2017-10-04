package com.product.marcus.nearbygrocery.ui.stores.di

import com.product.marcus.nearbygrocery.ui.stores.storelist.StoreListActivity
import dagger.Module
import dagger.Provides

/**
 * Created by Marcus on 10/4/2017.
 */
@Module
class StoreListContextModule(internal var storeListContext: StoreListActivity) {

    @StoreListScope
    @Provides
    internal fun provideGroceryListContext(): StoreListActivity {
        return storeListContext
    }


}