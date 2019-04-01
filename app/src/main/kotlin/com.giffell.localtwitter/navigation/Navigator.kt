package com.giffell.localtwitter.navigation

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.giffell.localtwitter.navigation.commands.Add
import com.giffell.localtwitter.navigation.commands.NewScreenChain
import com.giffell.localtwitter.ui.authorization.view.AuthorizationFragment
import com.giffell.localtwitter.ui.new_tweet.view.NewTweetFragment
import com.giffell.localtwitter.ui.tweets.view.TweetsFragment
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import ru.terrakok.cicerone.commands.Replace

class Navigator(
    private val activity: AppCompatActivity,
    private val containerId: Int
) : NavigatorAbs(activity, containerId) {

    override fun createFragment(
        screenKey: String,
        data: Any?
    ): Fragment = when (Screens.valueOf(screenKey)) {
        Screens.AUTHORIZATION -> AuthorizationFragment()
        Screens.TWEETS_LIST -> TweetsFragment()
        Screens.ADD_TWEET -> NewTweetFragment()
    }

    override fun exit() {
        activity.finish()
    }

    override fun showSystemMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun applyCommand(command: Command?) {
        if (command is Replace) {
            val fragment = createFragment(command.screenKey, command.transitionData)
            val fragmentManager = activity.supportFragmentManager
            if (fragmentManager.backStackEntryCount > 0) {
                fragmentManager.popBackStack()
                fragmentManager
                    .beginTransaction()
                    .replace(containerId, fragment)
                    .addToBackStack(command.screenKey)
                    .commit()
            } else {
                fragmentManager
                    .beginTransaction()
                    .replace(containerId, fragment)
                    .commit()
            }
            return
        } else if (command is Back) {
            if (activity.supportFragmentManager.backStackEntryCount == 1) {
                activity.finish()
                return
            }
        }

        super.applyCommand(command)
        when (command) {
            is Add -> {
                if (command.screenKey == null) {
                    unknownScreen(command)
                    return
                }
                val fragmentManager = activity.supportFragmentManager
                val fragment = createFragment(command.screenKey, command.data)

                fragmentManager
                    .beginTransaction()
                    .add(containerId, fragment)
                    .addToBackStack(command.screenKey)
                    .commit()
            }
            is NewScreenChain -> applyCommands(arrayOf(BackTo(null), Forward(command.screenKey, command.data)))
        }
    }
}
