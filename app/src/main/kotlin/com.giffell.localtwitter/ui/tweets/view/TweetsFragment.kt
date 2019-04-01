package com.giffell.localtwitter.ui.tweets.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.giffell.localtwitter.R
import com.giffell.localtwitter.dagger.tweets.TweetsModule
import com.giffell.localtwitter.database.entity.TweetEntity
import com.giffell.localtwitter.extentions.makeGone
import com.giffell.localtwitter.extentions.makeVisible
import com.giffell.localtwitter.navigation.Router
import com.giffell.localtwitter.navigation.Screens
import com.giffell.localtwitter.pref.PreferenceUtils
import com.giffell.localtwitter.ui.common.BaseMvpFragment
import com.giffell.localtwitter.ui.tweets.presenter.TweetsPresenter
import kotlinx.android.synthetic.main.tweets_fragment.*
import javax.inject.Inject

class TweetsFragment : BaseMvpFragment(), ITweetsView {

    @Inject
    @InjectPresenter
    lateinit var presenter: TweetsPresenter

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var preferenceUtils: PreferenceUtils

    @ProvidePresenter
    fun providePresenter() = presenter

    private val tweetsAdapter = TweetsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().plus(TweetsModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun enableOptionsMenu(): Boolean {
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        return inflater.inflate(R.menu.tweets_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.authorization_settings) {
            preferenceUtils.setBoolean(PreferenceUtils.USER_LOGGED_IN, false)
            router.newRootScreen(Screens.AUTHORIZATION)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tweets_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        addTweetButton.setOnClickListener { router.navigateTo(Screens.ADD_TWEET, this) }
    }

    private fun initRecyclerView() {
        tweetsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = tweetsAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.checkUpdateData()
    }

    override fun showTweets(tweets: List<TweetEntity>) {
        tweetsAdapter.setData(tweets)
    }

    override fun showProgress() {
        progressBar.makeVisible()
    }

    override fun hideProgress() {
        progressBar.makeGone()
    }
}