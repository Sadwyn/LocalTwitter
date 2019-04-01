package com.giffell.localtwitter.dagger.repository

import com.giffell.localtwitter.database.TweetsDatabase
import com.giffell.localtwitter.repositories.ITweetsRepository
import com.giffell.localtwitter.repositories.TweetsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideTweetsRepository(
        database: TweetsDatabase
    ): ITweetsRepository = TweetsRepository(database)
}