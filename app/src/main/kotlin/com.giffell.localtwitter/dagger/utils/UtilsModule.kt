package com.giffell.localtwitter.dagger.utils

import android.content.Context
import com.giffell.localtwitter.pref.PreferenceUtils
import com.giffell.localtwitter.rx.RxSchedulers
import com.giffell.localtwitter.rx.RxSchedulersAbs
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {

    @Provides
    @Singleton
    internal fun provideRxSchedulersAbs(): RxSchedulersAbs {
        return RxSchedulers()
    }

    @Provides
    @Singleton
    internal fun providePreferenceUtils(context : Context): PreferenceUtils{
        return PreferenceUtils(context.getSharedPreferences(PreferenceUtils.PREF_NAME, Context.MODE_PRIVATE))
    }

}