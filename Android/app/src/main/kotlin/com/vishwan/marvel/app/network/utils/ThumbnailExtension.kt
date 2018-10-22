package com.vishwan.marvel.app.network.utils

import com.vishwan.marvel.app.network.models.Thumbnail

fun Thumbnail.getUrl(): String? {
    return path.plus(".").plus(extension)
}