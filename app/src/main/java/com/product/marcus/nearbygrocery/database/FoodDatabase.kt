package com.product.marcus.nearbygrocery.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by Marcus on 9/25/2017.
 */
@Database(entities = arrayOf(Item::class), version = 2)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}