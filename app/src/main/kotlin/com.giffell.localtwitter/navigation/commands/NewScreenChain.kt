package com.giffell.localtwitter.navigation.commands

import ru.terrakok.cicerone.commands.Command

data class NewScreenChain(val screenKey: String?, val data: Any?) : Command