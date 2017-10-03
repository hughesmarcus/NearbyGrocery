package com.product.marcus.nearbygrocery.GroceryList.list

import com.product.marcus.nearbygrocery.database.Item
import com.product.marcus.nearbygrocery.database.ItemDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class GroceryListPresenter @Inject constructor(val itemDao: ItemDao) {

    val compositeDisposable = CompositeDisposable()
    var items = ArrayList<Item>()

    var view: GroceryListView? = null

    fun onCreate(groceryListView: GroceryListView) {
        view = groceryListView
        loadItems()
    }

    fun onDestroy() {
        compositeDisposable.dispose()
        view = null
    }

    private fun loadItems() {
        compositeDisposable.add(itemDao.getAllItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    items.clear()
                    items.addAll(it)
                    (items.size - 1).takeIf { it >= 0 }?.let {
                        view?.itemAddedAt(it)
                        view?.scrollTo(it)
                        view?.itemUpdatedAt(it)
                    }

                }))
        view?.showItems(items)

    }

    fun updateItem(item: Item) {
        compositeDisposable.add(Observable.fromCallable { itemDao.updateItem(item) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                }))


    }

}