package com.giffell.localtwitter.ui.common

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatFragment
import com.giffell.localtwitter.dagger.activity.BaseActivity

abstract class BaseMvpFragment : MvpAppCompatFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(enableOptionsMenu())
    }

    open fun enableOptionsMenu() = false

    fun getActivityComponent() = (activity as BaseActivity).activityComponent

}