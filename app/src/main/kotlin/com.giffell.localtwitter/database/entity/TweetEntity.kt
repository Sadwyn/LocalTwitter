package com.giffell.localtwitter.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class TweetEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var message: String = ""
)



