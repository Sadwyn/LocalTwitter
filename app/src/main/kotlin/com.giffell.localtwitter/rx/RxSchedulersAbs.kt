package com.giffell.localtwitter.rx

import io.reactivex.Scheduler

abstract class RxSchedulersAbs {
    abstract val mainThreadScheduler: Scheduler
    abstract val ioScheduler: Scheduler
    abstract val computationScheduler: Scheduler
}