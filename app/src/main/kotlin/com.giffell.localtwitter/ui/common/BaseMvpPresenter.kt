package com.giffell.localtwitter.ui.common

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.giffell.localtwitter.ui.common.moxy.MvpProgressView
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseMvpPresenter<View : MvpView> : MvpPresenter<View>() {

    private val disposables = CompositeDisposable()

    private val progressView = viewState as? MvpProgressView

    private fun showProgress() = progressView?.showProgress()

    private fun hideProgress() = progressView?.hideProgress()

    protected fun <T> Maybe<T>.withProgress(): Maybe<T> {
        return doOnSubscribe {
            showProgress()
        }.doAfterTerminate {
            hideProgress()
        }
    }

    protected fun <T> Single<T>.withProgress(): Single<T> {
        return doOnSubscribe {
            showProgress()
        }.doAfterTerminate {
            hideProgress()
        }
    }

    protected fun Completable.withProgress(): Completable {
        return doOnSubscribe {
            showProgress()
        }.doAfterTerminate {
            hideProgress()
        }
    }

    override fun detachView(view: View) {
        hideProgress()
        super.detachView(view)
    }

    fun Disposable.unsubscribeOnDestroy(): Disposable {
        disposables.add(this)
        return this
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}