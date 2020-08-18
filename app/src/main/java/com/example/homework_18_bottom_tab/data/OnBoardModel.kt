package com.example.homework_18_bottom_tab.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OnBoardModel(
    val image:Int,
    val desc:String
):Parcelable