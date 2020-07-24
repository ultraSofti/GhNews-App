package com.ultrasoft.ghnewsapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class News(

    @SerializedName("_id")
    val newsId: String?,
    @SerializedName("headline")
    val newsHeadline: String?,
    @SerializedName("content")
    val newsContent: String?,
    @SerializedName("date")
    val newsDate: String?,
    @SerializedName("imageUrl")
    val newsImage: String?,
    @SerializedName("category")
    val newsCategory: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(newsId)
        parcel.writeString(newsHeadline)
        parcel.writeString(newsContent)
        parcel.writeString(newsDate)
        parcel.writeString(newsImage)
        parcel.writeString(newsCategory)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<News> {
        override fun createFromParcel(parcel: Parcel): News {
            return News(parcel)
        }

        override fun newArray(size: Int): Array<News?> {
            return arrayOfNulls(size)
        }
    }

}
