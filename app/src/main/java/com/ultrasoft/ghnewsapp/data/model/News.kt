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
)

