package com.unoth.cryptoapp.di

import android.app.Application
import com.unoth.cryptoapp.data.database.AppDatabase
import com.unoth.cryptoapp.data.database.CoinInfoDao
import com.unoth.cryptoapp.data.network.ApiFactory
import com.unoth.cryptoapp.data.network.ApiService
import com.unoth.cryptoapp.data.repository.CoinRepositoryImpl
import com.unoth.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(application: Application): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}