package com.giffell.localtwitter

import android.app.Application
import com.giffell.localtwitter.dagger.AndroidModule
import com.giffell.localtwitter.dagger.AppComponent
import com.giffell.localtwitter.dagger.DaggerAppComponent
import com.giffell.localtwitter.navigation.INavigationFactory
import javax.inject.Inject

class MobileApplication : Application() {

    @Inject
    lateinit var navigationFactory: INavigationFactory

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        buildDagger()
    }

    private fun buildDagger() {
        appComponent = DaggerAppComponent.builder()
            .androidModule(AndroidModule(this))
            .build()
        appComponent.inject(this)
    }
}