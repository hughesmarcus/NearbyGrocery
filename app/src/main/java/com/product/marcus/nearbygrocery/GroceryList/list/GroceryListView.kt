package com.product.marcus.nearbygrocery.GroceryList.list

import com.product.marcus.nearbygrocery.database.Item

/**
 * Created by Marcus on 9/27/2017.
 */
interface GroceryListView {
    fun showItems(tasks: List<Item>)

    fun itemAddedAt(position: Int)

    fun scrollTo(position: Int)
}