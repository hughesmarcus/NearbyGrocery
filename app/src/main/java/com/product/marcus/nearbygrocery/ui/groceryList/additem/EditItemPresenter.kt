package com.product.marcus.nearbygrocery.ui.groceryList.additem

import com.product.marcus.nearbygrocery.database.Item
import com.product.marcus.nearbygrocery.database.ItemDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Marcus on 9/27/2017.
 */
class EditItemPresenter @Inject constructor(val itemDao: ItemDao) {
    val compositeDisposable = CompositeDisposable()

    var view: EditItemView? = null

    fun onCreate(editItemView: EditItemView) {
        view = editItemView

    }

    fun onDestroy() {
        compositeDisposable.dispose()
        view = null
    }

    fun addItem(item: Item) {

        compositeDisposable.add(Observable.fromCallable { itemDao.insertItem(item) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                }))


    }

    fun updateItem(item: Item) {
        compositeDisposable.add(Observable.fromCallable { itemDao.updateItem(item) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                }))


    }

    fun deleteItem(item: Item) {
        compositeDisposable.add(Observable.fromCallable { itemDao.deleteItem(item) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                }))


    }

}