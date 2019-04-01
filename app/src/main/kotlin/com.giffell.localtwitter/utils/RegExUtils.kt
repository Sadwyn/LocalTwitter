package com.giffell.localtwitter.utils

object RegExUtils {

    val EMAIL_ADDRESS_PATTERN =
        Regex("^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\.[a-z]{2,6})$")
    val PASSWORD_PATTERN = Regex("^[-a-zA-Zа-яА-Я0-9-.@&!?:+*/=#№%\$^;}{\\'?]{6,50}")
}