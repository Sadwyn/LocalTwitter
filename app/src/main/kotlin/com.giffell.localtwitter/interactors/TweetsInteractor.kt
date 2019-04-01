package com.giffell.localtwitter.interactors

import com.giffell.localtwitter.database.entity.TweetEntity
import com.giffell.localtwitter.repositories.ITweetsRepository
import io.reactivex.Completable
import io.reactivex.Maybe

class TweetsInteractor(
    private val tweetsRepository: ITweetsRepository
) {

    var isNeedUpdateData: Boolean = false

    fun getAllTweets(): Maybe<List<TweetEntity>> {
        return tweetsRepository.getAllTweets()
    }

    fun addTweet(tweetEntity: TweetEntity): Completable {
        return tweetsRepository.addTweet(tweetEntity)
    }

    fun addTweets(tweetList: List<TweetEntity>): Completable {
        return tweetsRepository.addTweets(tweetList)
    }
}