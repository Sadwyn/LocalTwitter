package com.giffell.localtwitter.dagger.activity

import com.giffell.localtwitter.dagger.authorization.AuthorizationComponent
import com.giffell.localtwitter.dagger.authorization.AuthorizationModule
import com.giffell.localtwitter.dagger.addtweet.NewTweetComponent
import com.giffell.localtwitter.dagger.addtweet.NewTweetModule
import com.giffell.localtwitter.dagger.scopes.ActivityScope
import com.giffell.localtwitter.dagger.tweets.TweetsComponent
import com.giffell.localtwitter.dagger.tweets.TweetsModule
import com.giffell.localtwitter.ui.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun plus(authorizationModule: AuthorizationModule): AuthorizationComponent
    fun plus(tweetsModule: TweetsModule): TweetsComponent
    fun plus(newTweetModule: NewTweetModule): NewTweetComponent

    fun inject(activity: MainActivity)
    fun inject(activity: BaseActivity)
}