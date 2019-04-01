package com.giffell.localtwitter.dagger.authorization

import com.giffell.localtwitter.dagger.scopes.FragmentScope
import com.giffell.localtwitter.ui.authorization.view.AuthorizationFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        AuthorizationModule::class
    ]
)
interface AuthorizationComponent {

    fun inject(authorizationFragment: AuthorizationFragment)

}