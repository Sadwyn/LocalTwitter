package com.giffell.localtwitter.rx

import android.os.Looper
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxSchedulers : RxSchedulersAbs() {

    override val mainThreadScheduler: Scheduler
        get() = AndroidSchedulers.from(Looper.getMainLooper(), true)

    override val ioScheduler: Scheduler
        get() = Schedulers.io()

    override val computationScheduler: Scheduler
        get() = Schedulers.computation()
}