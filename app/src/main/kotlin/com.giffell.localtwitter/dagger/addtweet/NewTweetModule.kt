package com.giffell.localtwitter.dagger.addtweet

import com.giffell.localtwitter.dagger.scopes.FragmentScope
import com.giffell.localtwitter.interactors.TweetsInteractor
import com.giffell.localtwitter.rx.RxSchedulersAbs
import com.giffell.localtwitter.ui.new_tweet.presenter.NewTweetPresenter
import dagger.Module
import dagger.Provides

@Module
class NewTweetModule {
    @Provides
    @FragmentScope
    internal fun provideNewTweetPresenter(
        newTweetsInteractor: TweetsInteractor,
        rxSchedulers: RxSchedulersAbs
    ): NewTweetPresenter {
        return NewTweetPresenter(newTweetsInteractor, rxSchedulers)
    }
}
