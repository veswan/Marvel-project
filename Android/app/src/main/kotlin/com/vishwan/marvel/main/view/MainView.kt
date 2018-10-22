package com.vishwan.marvel.main.view

import com.vishwan.marvel.app.model.ComicItem
import com.vishwan.marvel.main.di.MainComponent

interface MainView {
    fun injectDependencies(mainComponent: MainComponent)
    fun displayComics(comicsList: List<ComicItem>)
    fun setLoadingState(loading: Boolean)
    fun showErrorDialog()
    fun isInternetAvailable(): Boolean
}