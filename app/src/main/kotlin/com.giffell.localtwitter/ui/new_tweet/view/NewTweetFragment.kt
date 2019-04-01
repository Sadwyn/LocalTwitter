package com.giffell.localtwitter.ui.new_tweet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.giffell.localtwitter.R
import com.giffell.localtwitter.dagger.addtweet.NewTweetModule
import com.giffell.localtwitter.extentions.afterTextChanged
import com.giffell.localtwitter.navigation.Router
import com.giffell.localtwitter.navigation.Screens
import com.giffell.localtwitter.ui.common.BaseMvpFragment
import com.giffell.localtwitter.ui.new_tweet.presenter.NewTweetPresenter
import kotlinx.android.synthetic.main.new_tweet_layout.*
import javax.inject.Inject

class NewTweetFragment : BaseMvpFragment(), INewTweetView {

    @Inject
    @InjectPresenter
    lateinit var presenter: NewTweetPresenter

    @Inject
    lateinit var router: Router

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().plus(NewTweetModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.new_tweet_layout, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendTweet.isEnabled = false

        tweetText.afterTextChanged {
            sendTweet.isEnabled = it.isNotEmpty()
        }

        sendTweet.setOnClickListener {
            Toast.makeText(context, "Tweet has been created", Toast.LENGTH_SHORT).show()
            presenter.addTweet(tweetText.text.toString())
        }
    }

    override fun onTweetAdded() {
        router.backTo(Screens.TWEETS_LIST.name)
    }
}