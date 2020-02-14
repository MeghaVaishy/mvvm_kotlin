package com.example.mvvmkotlinapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitRepo(@Expose @SerializedName("author") val author: String? = null,
                   @Expose @SerializedName("avatar") val avatar: String? = null,
                   @Expose @SerializedName("url") val url: String? = null,
                   @Expose @SerializedName("description") val description: String? = null,
                   @Expose @SerializedName("languageColor") val languageColor: String? = null,
                   @Expose @SerializedName("stars") val stars: String? = null,
                   @Expose @SerializedName("forks") val forks: Int? = null,
                   @Expose @SerializedName("currentPeriodStars") val currentPeriodStars: Int? = null,
                   @Expose @SerializedName("builtBy") val builtBy: List<BuiltBy>? = null): Parcelable


