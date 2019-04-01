package com.giffell.localtwitter.navigation.commands

import ru.terrakok.cicerone.commands.Command

data class Add(val screenKey: String?, val data: Any?) : Command