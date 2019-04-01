package com.giffell.localtwitter.dagger.tweets

import com.giffell.localtwitter.dagger.scopes.FragmentScope
import com.giffell.localtwitter.ui.tweets.view.TweetsFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        TweetsModule::class
    ]
)
interface TweetsComponent {
    fun inject(tweetsFragment: TweetsFragment)
}