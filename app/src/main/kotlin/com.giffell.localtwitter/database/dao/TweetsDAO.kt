package com.giffell.localtwitter.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.giffell.localtwitter.database.entity.TweetEntity
import io.reactivex.Maybe

@Dao
interface TweetsDAO {

    @Query("SELECT * FROM TweetEntity")
    fun getAll(): Maybe<List<TweetEntity>>

    @Insert
    fun insert(offlineAsset: TweetEntity)

    @Insert
    fun insert(offlineAsset: List<TweetEntity>)

    @Update
    fun update(offlineAsset: TweetEntity)

    @Delete
    fun delete(offlineAsset: TweetEntity)
}