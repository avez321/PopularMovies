package com.example.moviesapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movies_table")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    var dbId: Int = 0,

    @SerializedName("adult")
    @Expose
    @Ignore
    var adult: Boolean ?= null,
    @SerializedName("backdrop_path")
    @Expose
    var backdrop_path: String ?= null,
    @SerializedName("genre_ids")
    @Expose
    @Ignore
    var genre_ids: List<Int> ?= null,
    @SerializedName("id")
    @Expose
    var id: Int ?= null,
    @SerializedName("original_language")
    @Expose
    @Ignore
    var original_language: String?= null,
    @SerializedName("original_title")
    @Expose
    var original_title: String?= null,
    @SerializedName("overview")
    @Expose
    var overview: String?= null,
    @SerializedName("popularity")
    @Expose
    @Ignore
    var popularity: Double?= null,
    @SerializedName("poster_path")
    @Expose
    var poster_path: String?= null,
    @SerializedName("release_date")
    @Expose
    var release_date: String?= null,
    @SerializedName("title")
    @Expose
    var title: String?= null,
    @SerializedName("video")
    @Expose
    var video: Boolean?= null,
    @SerializedName("vote_average")
    @Expose
    var vote_average: Double?= null,
    @SerializedName("vote_count")
    @Expose
    var vote_count: Int?= null
): Parcelable