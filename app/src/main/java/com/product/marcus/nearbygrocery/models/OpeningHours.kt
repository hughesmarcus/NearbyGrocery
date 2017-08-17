package com.product.marcus.nearbygrocery.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OpeningHours : Parcelable {

    @SerializedName("open_now")
    @Expose
    var openNow: Boolean? = null
    @SerializedName("weekday_text")
    @Expose
    var weekdayText: List<Any>? = null

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(openNow)
        dest.writeList(weekdayText)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<OpeningHours> = object : Parcelable.Creator<OpeningHours> {


            override fun createFromParcel(`in`: Parcel): OpeningHours {
                val instance = OpeningHours()
                instance.openNow = `in`.readValue(Boolean::class.java.classLoader) as Boolean
                `in`.readList(instance.weekdayText, Any::class.java.classLoader)
                return instance
            }

            override fun newArray(size: Int): Array<OpeningHours?> {
                return arrayOfNulls(size)
            }

        }
    }

}
