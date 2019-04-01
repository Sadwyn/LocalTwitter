package com.giffell.localtwitter.ui

import android.os.Bundle
import com.giffell.localtwitter.R
import com.giffell.localtwitter.dagger.activity.BaseActivity
import com.giffell.localtwitter.navigation.Router
import com.giffell.localtwitter.navigation.Screens
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent.inject(this)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        router.navigateTo(Screens.AUTHORIZATION)
    }

    override fun onBackPressed() {
        router.back()
    }
}
