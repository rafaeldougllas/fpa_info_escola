package com.rafaelbarreto.infoescola

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Geometry(
        val type: String,
        val coordinates: List<List<List<Double>>>
) : Parcelable