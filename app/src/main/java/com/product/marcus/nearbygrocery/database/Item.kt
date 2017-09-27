package com.product.marcus.nearbygrocery.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by Marcus on 9/25/2017.
 */
@Entity(tableName = "groceries")
data class Item(
        @PrimaryKey
        @ColumnInfo(name = "name") var name: String = "",
        @ColumnInfo(name = "price") var price: String = "",
        @ColumnInfo(name = "store") var place: String = "",
        @ColumnInfo(name = "quantity") var quantity: String = "",
        @ColumnInfo(name = "unit") var unit: String = "",
        @ColumnInfo(name = "notes") var notes: String = "",
        @ColumnInfo(name = "checked") var checked: Boolean,
        @ColumnInfo(name = "date_added_ms") var dateMS: Long = Calendar.getInstance().timeInMillis
)