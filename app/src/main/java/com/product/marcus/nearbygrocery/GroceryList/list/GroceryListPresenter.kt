package com.product.marcus.nearbygrocery.GroceryList.list

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

    fun loadItems() {
        compositeDisposable.add(itemDao.getAllItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    items.clear()
                    items.addAll(it)
                    (items.size - 1).takeIf { it >= 0 }?.let {
                        view?.itemAddedAt(it)
                        view?.scrollTo(it)
                    }

                }))
        view?.showItems(items)

    }

    fun addNewItem(name: String) {
        val newitem = Item(name = name, checked = false)
        compositeDisposable.add(Observable.fromCallable { itemDao.insertItem(newitem) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
    }
}