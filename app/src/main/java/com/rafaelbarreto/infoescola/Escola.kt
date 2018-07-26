package com.rafaelbarreto.infoescola

import android.os.Parcel
import android.os.Parcelable

data class Escola(
    var escola_nome: String,
    var endereco: String,
    var imageUrl: String) :  Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(escola_nome)
        parcel.writeString(endereco)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Escola> {
        override fun createFromParcel(parcel: Parcel): Escola {
            return Escola(parcel)
        }

        override fun newArray(size: Int): Array<Escola?> {
            return arrayOfNulls(size)
        }
    }
}
