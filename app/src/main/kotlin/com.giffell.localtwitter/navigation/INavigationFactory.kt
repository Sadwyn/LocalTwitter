package com.giffell.localtwitter.navigation

import android.support.v7.app.AppCompatActivity

interface INavigationFactory {

    fun createNavigator(activity: AppCompatActivity, containerId: Int): NavigatorAbs
}