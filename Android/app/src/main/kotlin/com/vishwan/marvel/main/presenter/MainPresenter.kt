package com.vishwan.marvel.main.presenter

import com.vishwan.marvel.app.model.ComicItem
import com.vishwan.marvel.app.network.enums.SortingOrder
import com.vishwan.marvel.app.presenter.BasePresenter


interface MainPresenter<ViewInterface> : BasePresenter<ViewInterface> {

    val comicsList: List<ComicItem>
    fun getComics(count: Int, orderBy: SortingOrder)

}