package com.example.myapplication.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhoto(
    val id : String,
    val description: String,
    val urls: UnsplashPhotoUrls,
    val user: UnsplashUser
): Parcelable{

}
