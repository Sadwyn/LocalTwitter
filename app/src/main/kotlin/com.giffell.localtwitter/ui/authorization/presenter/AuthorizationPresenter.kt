package com.giffell.localtwitter.ui.authorization.presenter

import com.arellomobile.mvp.InjectViewState
import com.giffell.localtwitter.interactors.AuthorizationInteractor
import com.giffell.localtwitter.pref.PreferenceUtils
import com.giffell.localtwitter.ui.authorization.view.IAuthorizationView
import com.giffell.localtwitter.ui.common.BaseMvpPresenter

@InjectViewState
class AuthorizationPresenter(
    private val authorizationInteractor: AuthorizationInteractor,
    private val preferenceUtils: PreferenceUtils
) : BaseMvpPresenter<IAuthorizationView>() {

    fun onLoginButtonClicked(login: String, password: String) {
        var isValid = true


        if (!authorizationInteractor.isValidLogin(login)) {
            isValid = false
            viewState.showLoginError()
        } else {
            viewState.clearLoginError()
        }

        if (!authorizationInteractor.isValidPassword(password)) {
            isValid = false
            viewState.showPasswordError()
        } else {
            viewState.clearPasswordError()
        }

        if (isValid) {
            authorizationInteractor.isUserRegistered(login, password, checkIsUserRegistered())
        }
    }

    private fun checkIsUserRegistered(): (Boolean, Boolean) -> Unit {
        return { isLoginRegistered: Boolean, isPasswordRegistered: Boolean ->
            if (isLoginRegistered) {
                viewState.clearEmailNotRegisteredError()
                if (isPasswordRegistered) {
                    viewState.clearPasswordWrongError()
                } else {
                    viewState.showPasswordWrongError()
                }
            } else {
                viewState.showEmailNotRegisteredError()
            }

            if (isLoginRegistered && isPasswordRegistered) {
                preferenceUtils.setBoolean(PreferenceUtils.USER_LOGGED_IN, true)
                viewState.login()
            }
        }
    }

    fun checkIsUserLoggedInBefore() {
        val isLogged = preferenceUtils.getBoolean(PreferenceUtils.USER_LOGGED_IN)
        if (isLogged) {
            viewState.autoLogin()
        }
    }
}

