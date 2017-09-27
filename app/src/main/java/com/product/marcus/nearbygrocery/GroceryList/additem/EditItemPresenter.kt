package com.product.marcus.nearbygrocery.GroceryList.additem

import com.product.marcus.nearbygrocery.application.AppController
import com.product.marcus.nearbygrocery.database.Item
import com.product.marcus.nearbygrocery.database.ItemDao
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Marcus on 9/27/2017.
 */
class EditItemPresenter {

    fun addItem(firstName: String, lastName: String) {
        val item = Item("pizza", "4.13", "Walmart", "4", "boxes of", "no date", false)

        Single.fromCallable {
            AppController.database?.itemDao()?.insertItem(item)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }
}