package com.giffell.localtwitter.dagger

import com.giffell.localtwitter.MobileApplication
import com.giffell.localtwitter.dagger.activity.ActivityComponent
import com.giffell.localtwitter.dagger.activity.ActivityModule
import com.giffell.localtwitter.dagger.interactors.InteractorsModule
import com.giffell.localtwitter.dagger.navigation.NavigationModule
import com.giffell.localtwitter.dagger.repository.RepositoryModule
import com.giffell.localtwitter.dagger.utils.UtilsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidModule::class,
        InteractorsModule::class,
        RepositoryModule::class,
        NavigationModule::class,
        TweetStoreModule::class,
        UtilsModule::class
    ]
)
interface AppComponent {

    fun plus(activityModule: ActivityModule): ActivityComponent

    fun inject(app: MobileApplication)
}