package com.vishwan.marvel.app.network.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Comics(
    @SerializedName("data")
    @Expose
    var data: Data? = null
)
