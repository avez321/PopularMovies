package com.example.moviesapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MoviesResponse(
    @SerializedName("dates")
    @Expose
    val dates: Dates? = null,
    @SerializedName("page")
    @Expose
    val page: Int = 0,
    @SerializedName("results")
    @Expose
    val results: ArrayList<Result>? = null,
    @SerializedName("total_pages")
    @Expose
    val total_pages: Int? = null,
    @SerializedName("total_results")
    @Expose
    val total_results: Int? = null
):Parcelable