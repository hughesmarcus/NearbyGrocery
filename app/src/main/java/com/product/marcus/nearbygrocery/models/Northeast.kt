package com.product.marcus.nearbygrocery.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Northeast : Parcelable {

    @SerializedName("lat")
    @Expose
    var lat: Double? = null
    @SerializedName("lng")
    @Expose
    var lng: Double? = null

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(lat)
        dest.writeValue(lng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Northeast> = object : Parcelable.Creator<Northeast> {


            override fun createFromParcel(`in`: Parcel): Northeast {
                val instance = Northeast()
                instance.lat = `in`.readValue(Double::class.java.classLoader) as Double
                instance.lng = `in`.readValue(Double::class.java.classLoader) as Double
                return instance
            }

            override fun newArray(size: Int): Array<Northeast?> {
                return arrayOfNulls(size)
            }

        }
    }

}
