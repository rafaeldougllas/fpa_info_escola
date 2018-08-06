package com.rafaelbarreto.infoescola

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class GeometrySchool (

        val type : String,
        val coordinates : List<List<List<Double>>>
) : Parcelable