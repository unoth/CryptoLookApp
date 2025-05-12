package com.unoth.cryptoapp.presentation

import android.app.Application
import com.unoth.cryptoapp.di.DaggerApplicationComponent

class CoinApp : Application() {
    val component by lazy{
        DaggerApplicationComponent.factory().create(this)
    }

}