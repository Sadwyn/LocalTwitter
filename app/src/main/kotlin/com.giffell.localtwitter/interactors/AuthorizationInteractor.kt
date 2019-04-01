package com.giffell.localtwitter.interactors

import com.giffell.localtwitter.utils.RegExUtils

class AuthorizationInteractor {
    fun isValidLogin(login: String) = RegExUtils.EMAIL_ADDRESS_PATTERN.matches(login)
    fun isValidPassword(password: String) = RegExUtils.PASSWORD_PATTERN.matches(password)
    fun isUserRegistered(login: String, password: String, isRegistered: (Boolean, Boolean) -> Unit) {
        isRegistered.invoke(login == LOGIN, password == PASSWORD)
    }

    companion object {
        private const val PASSWORD = "123456"
        private const val LOGIN = "test@google.com"
    }
}