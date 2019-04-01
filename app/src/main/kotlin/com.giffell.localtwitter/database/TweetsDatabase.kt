package com.giffell.localtwitter.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.giffell.localtwitter.database.dao.TweetsDAO
import com.giffell.localtwitter.database.entity.TweetEntity

@Database(
    entities = [
        TweetEntity::class
    ],
    version = 1
)
abstract class TweetsDatabase : RoomDatabase() {

    abstract fun tweetsDao(): TweetsDAO

    companion object {
        const val DATABASE_NAME = "tweets_content.db"
    }
}