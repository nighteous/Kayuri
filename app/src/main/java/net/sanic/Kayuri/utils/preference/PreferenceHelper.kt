package net.sanic.Kayuri.utils.preference

import android.content.Context

class PreferenceHelper(context: Context) {

    init {
        sharedPreference = Preference(context)
    }

    companion object {
        lateinit var sharedPreference: Preference
    }


}