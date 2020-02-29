package com.example.mvvmkotlinapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    @SerializedName("popularity")
    @Expose
    val popularity: Double? = null,

    @SerializedName("vote_count")
    @Expose
    val voteCount: Integer? = null,

    @SerializedName("video")
    @Expose
    val video: Boolean? = null,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String? = null,

    @SerializedName("id")
    @Expose
    val id: Integer? = null,

    @SerializedName("original_language")
    @Expose
    val originalLanguage: String? = null,

    @SerializedName("original_title")
    @Expose
    val originalTitle: String? = null,


    @SerializedName("title")
    @Expose
    val title: String? = null,

    @Expose
    @SerializedName("release_date")
    val releaseDate: String


):Parcelable
