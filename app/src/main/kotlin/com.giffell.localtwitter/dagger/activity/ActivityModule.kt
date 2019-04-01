package com.giffell.localtwitter.dagger.activity

import android.support.v7.app.AppCompatActivity
import com.giffell.localtwitter.R
import com.giffell.localtwitter.navigation.INavigationFactory
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(activity: AppCompatActivity, INavigationFactory: INavigationFactory) {

    private var navigator = INavigationFactory.createNavigator(activity, R.id.fragmentContainer)

    @Provides
    internal fun provideNavigator() = navigator
}