package com.product.marcus.nearbygrocery.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Photo : Parcelable {

    @SerializedName("height")
    @Expose
    var height: Int? = null
    @SerializedName("html_attributions")
    @Expose
    var htmlAttributions: List<String> = ArrayList<String>()
    @SerializedName("photo_reference")
    @Expose
    var photoReference: String? = null
    @SerializedName("width")
    @Expose
    var width: Int? = null

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(height)
        dest.writeList(htmlAttributions)
        dest.writeValue(photoReference)
        dest.writeValue(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Photo> = object : Parcelable.Creator<Photo> {


            override fun createFromParcel(`in`: Parcel): Photo {
                val instance = Photo()
                instance.height = `in`.readValue(Int::class.java.classLoader) as Int
                `in`.readList(instance.htmlAttributions, java.lang.String::class.java.classLoader)
                instance.photoReference = `in`.readValue(String::class.java.classLoader) as String
                instance.width = `in`.readValue(Int::class.java.classLoader) as Int
                return instance
            }

            override fun newArray(size: Int): Array<Photo?> {
                return arrayOfNulls(size)
            }

        }
    }

}
