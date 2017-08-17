package com.product.marcus.nearbygrocery.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Location : Parcelable {

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
        val CREATOR: Parcelable.Creator<Location> = object : Parcelable.Creator<Location> {


            override fun createFromParcel(`in`: Parcel): Location {
                val instance = Location()
                instance.lat = `in`.readValue(Double::class.java.classLoader) as Double
                instance.lng = `in`.readValue(Double::class.java.classLoader) as Double
                return instance
            }

            override fun newArray(size: Int): Array<Location?> {
                return arrayOfNulls(size)
            }

        }
    }

}
