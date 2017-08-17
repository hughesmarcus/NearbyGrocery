package com.product.marcus.nearbygrocery.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlaceResponse : Parcelable {

    @SerializedName("html_attributions")
    @Expose
    var htmlAttributions: List<Any>? = null
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
    @SerializedName("status")
    @Expose
    var status: String? = null

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeList(htmlAttributions)
        dest.writeList(results)
        dest.writeValue(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PlaceResponse> = object : Parcelable.Creator<PlaceResponse> {


            override fun createFromParcel(`in`: Parcel): PlaceResponse {
                val instance = PlaceResponse()
                `in`.readList(instance.htmlAttributions, Any::class.java.classLoader)
                `in`.readList(instance.results, Result::class.java.classLoader)
                instance.status = `in`.readValue(String::class.java.classLoader) as String
                return instance
            }

            override fun newArray(size: Int): Array<PlaceResponse?> {
                return arrayOfNulls(size)
            }

        }
    }

}
