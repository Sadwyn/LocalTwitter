package com.giffell.localtwitter.dagger.interactors

import com.giffell.localtwitter.interactors.AuthorizationInteractor
import com.giffell.localtwitter.interactors.NewTweetInteractor
import com.giffell.localtwitter.interactors.TweetsInteractor
import com.giffell.localtwitter.repositories.ITweetsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorsModule {

    @Provides
    @Singleton
    fun provideAuthorizationInteractor(): AuthorizationInteractor {
        return AuthorizationInteractor()
    }

    @Provides
    @Singleton
    fun provideTweetsInteractor(
        tweetsRepository: ITweetsRepository
    ): TweetsInteractor {
        return TweetsInteractor(tweetsRepository)
    }

    @Provides
    @Singleton
    fun provideNewTweetInteractor(): NewTweetInteractor {
        return NewTweetInteractor()
    }
}