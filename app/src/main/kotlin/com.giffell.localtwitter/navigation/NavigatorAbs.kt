package com.giffell.localtwitter.navigation

import android.support.v7.app.AppCompatActivity
import ru.terrakok.cicerone.android.SupportFragmentNavigator

abstract class NavigatorAbs(
    activity: AppCompatActivity,
    containerId: Int
) : SupportFragmentNavigator(activity.supportFragmentManager, containerId)