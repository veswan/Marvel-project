package com.vishwan.marvel.main.presenter

import com.vishwan.marvel.app.App
import com.vishwan.marvel.app.model.ComicItem
import com.vishwan.marvel.app.network.enums.SortingOrder
import com.vishwan.marvel.app.presenter.BasePresenterImpl
import com.vishwan.marvel.main.di.MainComponent
import com.vishwan.marvel.main.di.MainModule
import com.vishwan.marvel.main.domain.GetComicsUseCase
import com.vishwan.marvel.main.view.MainView
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import timber.log.Timber
import javax.inject.Inject

class MainPresenterImpl : BasePresenterImpl<MainView>(), MainPresenter<MainView> {

    @Inject
    internal lateinit var getComicsUseCase: GetComicsUseCase

    private var mainComponent: MainComponent? = null

    private val comics: MutableList<ComicItem> = mutableListOf()

    init {
        injectDependencies()
    }

    override fun onInjectDependencies() {
        mainComponent = App.get()
            .getAppComponent()
            ?.plus(MainModule())

        mainComponent?.inject(this)
    }

    override fun onViewAttached(view: MainView) {
        mainComponent?.let { view.injectDependencies(it) }
    }

    override val comicsList: List<ComicItem>
        get() = comics

    private fun updateComicsList(comicsList: List<ComicItem>) {
        if (comicsList.isEmpty()) {
            Timber.i("Received no data from use case, calling view to display error dialog!")
            getView()?.showErrorDialog()
        } else {
            Timber.i("Received data from use case, calling view to display data!")
            comics.clear()
            comics.addAll(comicsList)
            getView()?.displayComics(comics)
            getView()?.setLoadingState(false)
        }
    }

    override fun getComics(count: Int, orderBy: SortingOrder) {
        when (getView()?.isInternetAvailable()) {
            true -> {
                Timber.i("Presenter getComics called, calling use case!")
                getView()?.setLoadingState(true)
                launch(UI) {
                    updateComicsList(getComicsUseCase.execute(count, orderBy))
                }
            }
            false -> {
                Timber.i("Presenter getComics called, but no internet available!")
                getView()?.showErrorDialog()
            }
        }
    }

    override fun onPresenterDestroy() {

    }
}