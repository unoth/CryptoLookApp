package com.unoth.cryptoapp.di

import android.app.Application
import com.unoth.cryptoapp.data.database.AppDatabase
import com.unoth.cryptoapp.data.database.CoinInfoDao
import com.unoth.cryptoapp.data.repository.CoinRepositoryImpl
import com.unoth.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {
        @Provides
        fun provideCoinInfoDao(application: Application): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }
    }
}