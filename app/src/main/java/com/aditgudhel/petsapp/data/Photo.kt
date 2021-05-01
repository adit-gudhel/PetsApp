package com.aditgudhel.petsapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val id: String,
    val description: String?,
    val urls: PhotoUrls,
    val user: User
) : Parcelable {

    @Parcelize
    data class PhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String,
    ) : Parcelable

    @Parcelize
    data class User(
        val name: String,
        val username: String
    ) : Parcelable {
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=PetsApp&utm_medium=referral"
    }

}