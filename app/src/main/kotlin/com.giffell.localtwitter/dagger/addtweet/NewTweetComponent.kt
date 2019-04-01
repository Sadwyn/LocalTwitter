package com.giffell.localtwitter.dagger.addtweet

import com.giffell.localtwitter.dagger.scopes.FragmentScope
import com.giffell.localtwitter.ui.new_tweet.view.NewTweetFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        NewTweetModule::class
    ]
)
interface NewTweetComponent {
    fun inject(newTweetFragment: NewTweetFragment)
}
