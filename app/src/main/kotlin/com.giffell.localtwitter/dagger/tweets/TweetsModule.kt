package com.giffell.localtwitter.dagger.tweets

import android.content.res.Resources
import com.giffell.localtwitter.dagger.scopes.FragmentScope
import com.giffell.localtwitter.interactors.TweetsInteractor
import com.giffell.localtwitter.rx.RxSchedulersAbs
import com.giffell.localtwitter.ui.tweets.presenter.TweetsPresenter
import dagger.Module
import dagger.Provides

@Module
class TweetsModule {

    @Provides
    @FragmentScope
    internal fun provideTweetsPresenter(
        tweetsInteractor: TweetsInteractor,
        rxSchedulersAbs: RxSchedulersAbs,
        resources: Resources
    ): TweetsPresenter {
        return TweetsPresenter(tweetsInteractor, rxSchedulersAbs, resources)
    }
}