package com.vishwan.marvel.app.di

import com.vishwan.marvel.app.App
import com.vishwan.marvel.app.di.scopes.PerApplication
import com.vishwan.marvel.main.di.MainComponent
import com.vishwan.marvel.main.di.MainModule
import dagger.Component

@PerApplication
@Component(modules = [(AppModule::class), (NetworkModule::class)])
interface AppComponent {
    fun inject(application: App)
    fun plus(module: MainModule): MainComponent
}