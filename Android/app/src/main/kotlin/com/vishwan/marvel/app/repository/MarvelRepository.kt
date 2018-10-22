package com.vishwan.marvel.app.repository

import com.vishwan.marvel.app.network.enums.SortingOrder
import com.vishwan.marvel.app.network.models.Comics

interface MarvelRepository {

    fun getComics(count: Int, order: SortingOrder): Comics?

}