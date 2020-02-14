package com.example.mvvmkotlinapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class BuiltBy(
    @Expose
    @SerializedName("username")
    val username: String? = null,

    @Expose
    @SerializedName("href")
    val href: String? = null,

    @Expose
    @SerializedName("avatar")
    val avatar: String? = null
) : Parcelable
