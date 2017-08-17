package com.product.marcus.nearbygrocery.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Geometry : Parcelable {

    @SerializedName("location")
    @Expose
    var location: Location? = null
    @SerializedName("viewport")
    @Expose
    var viewport: Viewport? = null

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(location)
        dest.writeValue(viewport)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Geometry> = object : Parcelable.Creator<Geometry> {


            override fun createFromParcel(`in`: Parcel): Geometry {
                val instance = Geometry()
                instance.location = `in`.readValue(Location::class.java.classLoader) as Location
                instance.viewport = `in`.readValue(Viewport::class.java.classLoader) as Viewport
                return instance
            }

            override fun newArray(size: Int): Array<Geometry?> {
                return arrayOfNulls(size)
            }

        }
    }

}
