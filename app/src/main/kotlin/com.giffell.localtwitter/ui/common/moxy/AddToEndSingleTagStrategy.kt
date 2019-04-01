package com.giffell.localtwitter.ui.common.moxy

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.ViewCommand
import com.arellomobile.mvp.viewstate.strategy.StateStrategy

class AddToEndSingleTagStrategy : StateStrategy {

    override fun <View : MvpView> beforeApply(
        currentState: MutableList<ViewCommand<View>>,
        incomingCommand: ViewCommand<View>
    ) {

        val iterator = currentState.iterator()

        while (iterator.hasNext()) {
            val entry: ViewCommand<View>? = iterator.next()
            entry?.let {
                if (it.tag == incomingCommand.tag) {
                    iterator.remove()
                }
            }
        }

        currentState.add(incomingCommand)
    }

    override fun <View : MvpView> afterApply(
        currentState: MutableList<ViewCommand<View>>,
        incomingCommand: ViewCommand<View>
    ) {
    }
}