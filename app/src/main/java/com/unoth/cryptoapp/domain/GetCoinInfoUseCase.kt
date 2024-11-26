package com.unoth.cryptoapp.domain

class GetCoinInfoUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol)
}