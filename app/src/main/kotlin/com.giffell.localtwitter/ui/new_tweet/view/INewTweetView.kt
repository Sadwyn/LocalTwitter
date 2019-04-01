package com.giffell.localtwitter.ui.new_tweet.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface INewTweetView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onTweetAdded()
}