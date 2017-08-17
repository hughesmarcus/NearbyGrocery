package com.product.marcus.nearbygrocery.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result : Parcelable {

    @SerializedName("geometry")
    @Expose
    var geometry: Geometry? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("opening_hours")
    @Expose
    var openingHours: OpeningHours? = null
    @SerializedName("photos")
    @Expose
    var photos: List<Photo>? = ArrayList<Photo>()
    @SerializedName("place_id")
    @Expose
    var placeId: String? = null
    @SerializedName("rating")
    @Expose
    var rating: Double? = null
    @SerializedName("reference")
    @Expose
    var reference: String? = null
    @SerializedName("scope")
    @Expose
    var scope: String? = null
    @SerializedName("types")
    @Expose
    var types: List<String>? = ArrayList<String>()
    @SerializedName("vicinity")
    @Expose
    var vicinity: String? = null
    @SerializedName("price_level")
    @Expose
    var priceLevel: Int? = null

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(geometry)
        dest.writeValue(icon)
        dest.writeValue(id)
        dest.writeValue(name)
        dest.writeValue(openingHours)
        dest.writeList(photos)
        dest.writeValue(placeId)
        dest.writeValue(rating)
        dest.writeValue(reference)
        dest.writeValue(scope)
        dest.writeList(types)
        dest.writeValue(vicinity)
        dest.writeValue(priceLevel)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Result> = object : Parcelable.Creator<Result> {


            override fun createFromParcel(`in`: Parcel): Result {
                val instance = Result()
                instance.geometry = `in`.readValue(Geometry::class.java.classLoader) as? Geometry
                instance.icon = `in`.readValue(String::class.java.classLoader) as? String
                instance.id = `in`.readValue(String::class.java.classLoader) as? String
                instance.name = `in`.readValue(String::class.java.classLoader) as? String
                instance.openingHours = `in`.readValue(OpeningHours::class.java.classLoader) as? OpeningHours
                `in`.readList(instance.photos, Photo::class.java.classLoader)
                instance.placeId = `in`.readValue(String::class.java.classLoader) as? String
                instance.rating = `in`.readValue(Int::class.java.classLoader) as? Double
                instance.reference = `in`.readValue(String::class.java.classLoader) as? String
                instance.scope = `in`.readValue(String::class.java.classLoader) as? String
                `in`.readList(instance.types, java.lang.String::class.java.classLoader)
                instance.vicinity = `in`.readValue(String::class.java.classLoader) as? String
                instance.priceLevel = `in`.readValue(Int::class.java.classLoader) as? Int
                return instance
            }

            override fun newArray(size: Int): Array<Result?> {
                return arrayOfNulls(size)
            }

        }
    }

}
