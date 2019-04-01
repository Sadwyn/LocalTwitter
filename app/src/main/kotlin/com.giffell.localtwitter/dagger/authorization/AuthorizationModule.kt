package com.giffell.localtwitter.dagger.authorization

import com.giffell.localtwitter.dagger.scopes.FragmentScope
import com.giffell.localtwitter.interactors.AuthorizationInteractor
import com.giffell.localtwitter.pref.PreferenceUtils
import com.giffell.localtwitter.ui.authorization.presenter.AuthorizationPresenter
import dagger.Module
import dagger.Provides

@Module
class AuthorizationModule {

    @Provides
    @FragmentScope
    internal fun provideAuthorizationPresenter(
        authorizationInteractor: AuthorizationInteractor,
        preferenceUtils: PreferenceUtils
    ): AuthorizationPresenter {
        return AuthorizationPresenter(authorizationInteractor, preferenceUtils)
    }
}