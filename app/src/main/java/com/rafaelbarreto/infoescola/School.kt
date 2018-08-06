package com.rafaelbarreto.infoescola

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class School (
        val type: String,
        val id: Int,
        val properties: Properties,
        val geometry: Geometry
):Parcelable