package com.giffell.localtwitter.ui.tweets.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.giffell.localtwitter.database.entity.TweetEntity
import com.giffell.localtwitter.ui.common.moxy.MvpProgressView

interface ITweetsView : MvpView, MvpProgressView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showTweets(tweets: List<TweetEntity>)
}