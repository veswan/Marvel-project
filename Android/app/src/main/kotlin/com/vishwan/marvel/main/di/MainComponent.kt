package com.vishwan.marvel.main.di

import com.vishwan.marvel.app.di.scopes.PerPresenter
import com.vishwan.marvel.main.presenter.MainPresenterImpl
import com.vishwan.marvel.main.view.MainActivity
import dagger.Subcomponent

@PerPresenter
@Subcomponent(modules = [(MainModule::class)])
interface MainComponent {
    fun inject(mainPresenter: MainPresenterImpl)
    fun inject(mainActivity: MainActivity)
}