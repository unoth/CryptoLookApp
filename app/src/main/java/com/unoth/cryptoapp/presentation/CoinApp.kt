package com.unoth.cryptoapp.presentation

import android.app.Application
import androidx.work.Configuration
import com.unoth.cryptoapp.data.workers.RefreshDataWorkerFactory
import com.unoth.cryptoapp.di.DaggerApplicationComponent
import javax.inject.Inject

class CoinApp : Application(), Configuration.Provider {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    @Inject
    lateinit var workerFactory: RefreshDataWorkerFactory

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}