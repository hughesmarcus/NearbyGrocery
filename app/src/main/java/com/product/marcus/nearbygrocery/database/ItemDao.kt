package com.product.marcus.nearbygrocery.database

import android.arch.persistence.room.*
import io.reactivex.Flowable

/**
 * Created by Marcus on 9/25/2017.
 */
@Dao
interface ItemDao {


    @Query("SELECT * FROM groceries")
    fun getAllItems(): Flowable<List<Item>>

    //@Query("SELECT name FROM groceries WHERE store = :arg0")
    //fun getItemsAt(store: String): Flowable<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)

    @Update
    fun updateItem(item: Item)
}