package io.github.thang86.weathers.domain.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

data class Address(
    val icon: Int,
    val address: String?,
    val temperature: String?,
    val background: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(icon)
        parcel.writeString(address)
        parcel.writeString(temperature)
        parcel.writeInt(background)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Address> {
        override fun createFromParcel(parcel: Parcel): Address {
            return Address(parcel)
        }

        override fun newArray(size: Int): Array<Address?> {
            return arrayOfNulls(size)
        }
    }
}