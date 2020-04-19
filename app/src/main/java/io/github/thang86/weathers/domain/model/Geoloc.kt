package io.github.thang86.weathers.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Geoloc(

    @Json(name = "lng")
    val lng: Double? = null,

    @Json(name = "lat")
    val lat: Double? = null
)