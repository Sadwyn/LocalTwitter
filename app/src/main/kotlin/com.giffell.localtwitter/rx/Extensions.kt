package com.giffell.localtwitter.rx

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

fun <P> Single<P>.ioToMain(rxObservableAbs: RxSchedulersAbs): Single<P> {
    return subscribeOn(rxObservableAbs.ioScheduler)
        .observeOn(rxObservableAbs.mainThreadScheduler)
}

fun Completable.ioToMain(rxObservableAbs: RxSchedulersAbs): Completable {
    return subscribeOn(rxObservableAbs.ioScheduler)
        .observeOn(rxObservableAbs.mainThreadScheduler)
}

fun <P> Maybe<P>.ioToMain(rxObservableAbs: RxSchedulersAbs): Maybe<P> {
    return subscribeOn(rxObservableAbs.ioScheduler)
        .observeOn(rxObservableAbs.mainThreadScheduler)
}
