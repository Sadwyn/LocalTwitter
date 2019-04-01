package com.giffell.localtwitter.ui.new_tweet.presenter

import com.arellomobile.mvp.InjectViewState
import com.giffell.localtwitter.database.entity.TweetEntity
import com.giffell.localtwitter.interactors.TweetsInteractor
import com.giffell.localtwitter.rx.RxSchedulersAbs
import com.giffell.localtwitter.rx.ioToMain
import com.giffell.localtwitter.ui.common.BaseMvpPresenter
import com.giffell.localtwitter.ui.new_tweet.view.INewTweetView

@InjectViewState
class NewTweetPresenter(
    private val tweetsInteractor: TweetsInteractor,
    private val rxSchedulers: RxSchedulersAbs
) : BaseMvpPresenter<INewTweetView>() {

    fun addTweet(tweetMessage: String) {
        tweetsInteractor.addTweet(TweetEntity(message = tweetMessage))
            .ioToMain(rxSchedulers)
            .subscribe {
                tweetsInteractor.isNeedUpdateData = true
                viewState.onTweetAdded()
            }.unsubscribeOnDestroy()
    }
}