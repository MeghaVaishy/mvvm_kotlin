package com.example.mvvmkotlinapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TrendingResponse(
    @SerializedName("gitRepo")
    @Expose
    var gitRepo: List<GitRepo>? = null):Parcelable


