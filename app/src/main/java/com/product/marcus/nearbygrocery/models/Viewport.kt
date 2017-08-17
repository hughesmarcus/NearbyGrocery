package com.product.marcus.nearbygrocery.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Viewport : Parcelable {

    @SerializedName("northeast")
    @Expose
    var northeast: Northeast? = null
    @SerializedName("southwest")
    @Expose
    var southwest: Southwest? = null

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(northeast)
        dest.writeValue(southwest)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Viewport> = object : Parcelable.Creator<Viewport> {


            override fun createFromParcel(`in`: Parcel): Viewport {
                val instance = Viewport()
                instance.northeast = `in`.readValue(Northeast::class.java.classLoader) as Northeast
                instance.southwest = `in`.readValue(Southwest::class.java.classLoader) as Southwest
                return instance
            }

            override fun newArray(size: Int): Array<Viewport?> {
                return arrayOfNulls(size)
            }

        }
    }

}
