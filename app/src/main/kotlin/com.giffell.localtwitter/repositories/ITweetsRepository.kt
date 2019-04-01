package com.giffell.localtwitter.repositories

import com.giffell.localtwitter.database.entity.TweetEntity
import io.reactivex.Completable
import io.reactivex.Maybe

interface ITweetsRepository {

    fun getAllTweets(): Maybe<List<TweetEntity>>

    fun addTweet(tweetEntity: TweetEntity): Completable

    fun addTweets(tweetList: List<TweetEntity>): Completable
}