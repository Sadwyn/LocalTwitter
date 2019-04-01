package com.giffell.localtwitter.ui.tweets.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giffell.localtwitter.R
import com.giffell.localtwitter.database.entity.TweetEntity
import kotlinx.android.synthetic.main.tweet_item.view.*

class TweetsAdapter : RecyclerView.Adapter<TweetsAdapter.TweetViewHolder>() {

    private var tweets: List<TweetEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        return TweetViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tweet_item, parent, false))
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val item = tweets[position]
        holder.itemView.apply {
            tweetDescription.text = item.message
        }
    }

    fun setData(tweets: List<TweetEntity>) {
        this.tweets = tweets
        notifyDataSetChanged()
    }

    class TweetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}