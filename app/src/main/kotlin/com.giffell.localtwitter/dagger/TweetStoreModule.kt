package com.giffell.localtwitter.dagger

import android.arch.persistence.room.Room
import android.content.Context
import com.giffell.localtwitter.database.TweetsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TweetStoreModule {

    @Provides
    @Singleton
    fun provideTweetsDatabase(
        context: Context
    ): TweetsDatabase {
        return Room.databaseBuilder(
            context,
            TweetsDatabase::class.java,
            TweetsDatabase.DATABASE_NAME
        ).build()
    }
}