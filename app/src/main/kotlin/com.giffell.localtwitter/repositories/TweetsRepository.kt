package com.giffell.localtwitter.repositories

import com.giffell.localtwitter.database.TweetsDatabase
import com.giffell.localtwitter.database.entity.TweetEntity
import io.reactivex.Completable
import io.reactivex.Maybe

class TweetsRepository(private val database: TweetsDatabase) : ITweetsRepository {

    override fun addTweet(tweetEntity: TweetEntity): Completable {
        return Completable.fromCallable { database.tweetsDao().insert(tweetEntity) }
    }

    override fun getAllTweets(): Maybe<List<TweetEntity>> {
        return database.tweetsDao().getAll()
    }

    override fun addTweets(tweetList: List<TweetEntity>): Completable {
        return Completable.fromCallable { database.tweetsDao().insert(tweetList) }
    }
}