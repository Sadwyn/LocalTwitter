package com.giffell.localtwitter.dagger.navigation

import android.support.v7.app.AppCompatActivity
import com.giffell.localtwitter.navigation.INavigationFactory
import com.giffell.localtwitter.navigation.Navigator
import com.giffell.localtwitter.navigation.NavigatorAbs
import com.giffell.localtwitter.navigation.Router
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    internal fun provideNavigationFactory(): INavigationFactory = object : INavigationFactory {
        override fun createNavigator(activity: AppCompatActivity, containerId: Int): NavigatorAbs {
            return Navigator(activity, containerId)
        }
    }

    @Provides
    @Singleton
    fun provideCicerone(router: Router): Cicerone<Router> = Cicerone.create(router)

    @Provides
    @Singleton
    fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @Singleton
    fun provideRouter() = Router()
}