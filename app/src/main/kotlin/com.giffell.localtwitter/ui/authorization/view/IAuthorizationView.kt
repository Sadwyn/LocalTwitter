package com.giffell.localtwitter.ui.authorization.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.giffell.localtwitter.ui.common.moxy.AddToEndSingleTagStrategy

interface IAuthorizationView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun login()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = LOGIN)
    fun showLoginError()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = LOGIN)
    fun clearLoginError()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = PASSWORD)
    fun showPasswordError()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = PASSWORD)
    fun clearPasswordError()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = REGISTERED)
    fun showEmailNotRegisteredError()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = REGISTERED)
    fun clearEmailNotRegisteredError()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = REGISTERED)
    fun showPasswordWrongError()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = REGISTERED)
    fun clearPasswordWrongError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun autoLogin()

    companion object {
        private const val PASSWORD = "PASSWORD"
        private const val LOGIN = "LOGIN"
        private const val REGISTERED = "REGISTERED"
    }
}