package com.giffell.localtwitter.dagger.activity

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.giffell.localtwitter.MobileApplication
import com.giffell.localtwitter.navigation.NavigatorAbs
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigator: NavigatorAbs

    private lateinit var activityModule: ActivityModule
    private var _activityComponent: ActivityComponent? = null

    var activityComponent: ActivityComponent
        get() {
            if (_activityComponent == null) {
                activityModule = ActivityModule(this, (application as MobileApplication).navigationFactory)
                _activityComponent = (application as MobileApplication).appComponent.plus(activityModule)
            }
            return _activityComponent ?: throw AssertionError("Set to null")
        }
        set(value) {
            _activityComponent = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}