package com.giffell.localtwitter.ui.authorization.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.giffell.localtwitter.R
import com.giffell.localtwitter.dagger.authorization.AuthorizationModule
import com.giffell.localtwitter.navigation.Router
import com.giffell.localtwitter.navigation.Screens
import com.giffell.localtwitter.ui.authorization.presenter.AuthorizationPresenter
import com.giffell.localtwitter.ui.common.BaseMvpFragment
import kotlinx.android.synthetic.main.authorization_fragment.*
import javax.inject.Inject

class AuthorizationFragment : BaseMvpFragment(), IAuthorizationView {


    @Inject
    @InjectPresenter
    lateinit var presenter: AuthorizationPresenter

    @Inject
    lateinit var router: Router
    lateinit var handler: Handler
    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().plus(AuthorizationModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.authorization_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handler = Handler()
        presenter.checkIsUserLoggedInBefore()
        loginButton.setOnClickListener {
            presenter.onLoginButtonClicked(login.text.toString(), password.text.toString())
        }
    }

    override fun showLoginError() {
        loginView.error = getString(R.string.login_error_message)
        loginView.isErrorEnabled = true
    }

    override fun showPasswordError() {
        passwordView.error = getString(R.string.password_error_message)
        passwordView.isErrorEnabled = true
    }

    override fun clearLoginError() {
        loginView.error = null
        loginView.isErrorEnabled = false
    }

    override fun clearPasswordError() {
        passwordView.error = null
        passwordView.isErrorEnabled = false
    }

    override fun showEmailNotRegisteredError() {
        loginView.error = getString(R.string.user_not_registered_error)
        loginView.isErrorEnabled = true
    }

    override fun clearEmailNotRegisteredError() {
        loginView.error = null
        loginView.isErrorEnabled = false
    }

    override fun showPasswordWrongError() {
        passwordView.error = getString(R.string.wrong_password_error)
        passwordView.isErrorEnabled = true
    }

    override fun clearPasswordWrongError() {
        passwordView.error = null
        passwordView.isErrorEnabled = false
    }

    override fun login() {
        router.newRootScreen(Screens.TWEETS_LIST)
    }

    override fun autoLogin() {
        handler.post{router.newRootScreen(Screens.TWEETS_LIST)}
    }
}