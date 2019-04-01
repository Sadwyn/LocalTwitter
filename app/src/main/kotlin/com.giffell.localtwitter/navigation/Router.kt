package com.giffell.localtwitter.navigation

import com.giffell.localtwitter.navigation.commands.NewScreenChain
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.commands.Back

class Router : Router() {

    override fun newScreenChain(screenKey: String?, data: Any?) {
        executeCommands(NewScreenChain(screenKey, data))
    }

    fun newRootScreen(screen: Screens) {
        newRootScreen(screen.name)
    }

    fun navigateTo(screens: Screens) = navigateTo(screens.name)
    fun navigateTo(screens: Screens, data: Any?) = navigateTo(screens.name, data)

    fun back() = executeCommands(Back())
}