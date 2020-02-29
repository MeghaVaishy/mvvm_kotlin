package com.example.mvvmkotlinapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("page")
    @Expose
    val page: Integer? = null,
    @SerializedName("total_results")
    @Expose
    val totalResults: Integer? = null,
    @SerializedName("total_pages")
    @Expose
    val totalPages: Integer? = null,
    @SerializedName("results")
    @Expose
    val results: List<Result>? = null
) : Parcelable
