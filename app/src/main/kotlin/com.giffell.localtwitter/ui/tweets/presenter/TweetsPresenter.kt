package com.giffell.localtwitter.ui.tweets.presenter

import android.content.res.Resources
import com.arellomobile.mvp.InjectViewState
import com.giffell.localtwitter.R
import com.giffell.localtwitter.database.entity.TweetEntity
import com.giffell.localtwitter.interactors.TweetsInteractor
import com.giffell.localtwitter.rx.RxSchedulersAbs
import com.giffell.localtwitter.rx.ioToMain
import com.giffell.localtwitter.ui.common.BaseMvpPresenter
import com.giffell.localtwitter.ui.tweets.view.ITweetsView
import io.reactivex.Maybe

@InjectViewState
class TweetsPresenter(
    private val tweetsInteractor: TweetsInteractor,
    private val rxSchedulers: RxSchedulersAbs,
    private val resources: Resources
) : BaseMvpPresenter<ITweetsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadTweets()
    }

    private fun loadTweets() {
        tweetsInteractor.getAllTweets()
            .flatMap { tweets ->
                var tweetList = tweets
                if (tweets.isEmpty()) {
                    val localTweets = resources.getStringArray(R.array.tweets).map { TweetEntity(message = it) }
                    tweetList = localTweets
                    saveTweetsToDatabase(localTweets)
                }
                Maybe.just(tweetList)
            }
            .ioToMain(rxSchedulers)
            .withProgress()
            .subscribe(
                {
                    viewState.showTweets(it)
                },
                {
                    // TODO
                }
            )
            .unsubscribeOnDestroy()
    }

    private fun saveTweetsToDatabase(tweets: List<TweetEntity>) {
        tweetsInteractor.addTweets(tweets)
            .subscribe()
            .unsubscribeOnDestroy()
    }

    fun checkUpdateData() {
        if (tweetsInteractor.isNeedUpdateData) {
            tweetsInteractor.isNeedUpdateData = false
            loadTweets()
        }
    }
}