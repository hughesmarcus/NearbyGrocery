package com.product.marcus.nearbygrocery.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import android.support.design.internal.ParcelableSparseArray
import com.google.gson.annotations.Expose
import java.util.*
import com.product.marcus.nearbygrocery.R.id.notes
import com.product.marcus.nearbygrocery.R.id.price
import android.R.attr.checked
import com.google.gson.annotations.SerializedName


/**
 * Created by Marcus on 9/25/2017.
 */
@Entity(tableName = "groceries")
class Item : Parcelable {
        @PrimaryKey
        @SerializedName("name")
        @ColumnInfo(name = "name")
        var name: String = ""
    @ColumnInfo(name = "price")
    var price: Double = 0.0
    @ColumnInfo(name = "store")
    var store: String = ""
    @ColumnInfo(name = "quantity")
    var quantity: Int = 0
    @ColumnInfo(name = "unit")
    var unit: String = ""
    @ColumnInfo(name = "notes")
    var notes: String = ""
    @ColumnInfo(name = "checked")
    var checked: Boolean = false
    @ColumnInfo(name = "category")
    var category: String = ""

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(checked)
        dest.writeValue(name)
        dest.writeValue(price)
        dest.writeValue(store)
        dest.writeValue(quantity)
        dest.writeValue(unit)
        dest.writeValue(notes)
        dest.writeValue(category)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Item> = object : Parcelable.Creator<Item> {


            override fun createFromParcel(`in`: Parcel): Item {
                val instance = Item()
                instance.checked = (`in`.readValue((Boolean::class.java!!.getClassLoader())) as Boolean)
                instance.name = (`in`.readValue((String::class.java!!.getClassLoader())) as String)
                instance.price = (`in`.readValue((Double::class.java!!.getClassLoader())) as Double)
                instance.store = (`in`.readValue((String::class.java!!.getClassLoader())) as String)
                instance.quantity = (`in`.readValue((Int::class.java!!.getClassLoader())) as Int)
                instance.unit = (`in`.readValue((String::class.java!!.getClassLoader())) as String)
                instance.notes = (`in`.readValue((String::class.java!!.getClassLoader())) as String)
                instance.category = (`in`.readValue((String::class.java!!.getClassLoader())) as String)
                return instance
            }

            override fun newArray(size: Int): Array<Item?> {
                return arrayOfNulls(size)
            }

        }
    }

    override fun describeContents(): Int {
        return 0
    }

    fun Item() {}
    fun Item(checked: Boolean, name: String, price: Double, store: String, quantity: Int, unit: String, notes: String, category: String) {
        this.checked = checked
        this.name = name
        this.price = price
        this.store = store
        this.quantity = quantity
        this.unit = unit
        this.notes = notes
        this.category = category
    }
}
