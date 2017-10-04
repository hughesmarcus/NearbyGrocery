package com.product.marcus.nearbygrocery.ui.groceryList.list

import com.product.marcus.nearbygrocery.database.Item


interface GroceryListView {
    fun showItems(items: List<Item>)

    fun itemAddedAt(position: Int)

    fun scrollTo(position: Int)

    fun itemUpdatedAt(position: Int)
}