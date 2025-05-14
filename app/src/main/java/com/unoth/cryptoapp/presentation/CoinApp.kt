package com.unoth.cryptoapp.presentation

import android.app.Application
import androidx.work.Configuration
import com.unoth.cryptoapp.data.database.AppDatabase
import com.unoth.cryptoapp.data.mapper.CoinMapper
import com.unoth.cryptoapp.data.network.ApiFactory
import com.unoth.cryptoapp.data.workers.RefreshDataWorkerFactory
import com.unoth.cryptoapp.di.DaggerApplicationComponent

class CoinApp : Application(), Configuration.Provider {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(
                RefreshDataWorkerFactory(
                    AppDatabase.getInstance(this).coinPriceInfoDao(),
                    CoinMapper(),
                    ApiFactory.apiService
                )
            ).build()
}