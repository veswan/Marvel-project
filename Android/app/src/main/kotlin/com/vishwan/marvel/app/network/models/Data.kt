package com.vishwan.marvel.app.network.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
)
