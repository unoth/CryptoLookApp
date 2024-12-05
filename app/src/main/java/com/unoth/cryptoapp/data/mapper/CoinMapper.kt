package com.unoth.cryptoapp.data.mapper

import com.google.gson.Gson
import com.unoth.cryptoapp.data.database.CoinInfoDbModel
import com.unoth.cryptoapp.data.network.model.CoinInfoDto
import com.unoth.cryptoapp.data.network.model.CoinInfoJsonContainerDto
import com.unoth.cryptoapp.data.network.model.CoinNamesListDto
import com.unoth.cryptoapp.domain.CoinInfo

class CoinMapper {

    fun mapDtoToDbModel(dto: CoinInfoDto) = CoinInfoDbModel(
        fromsymbol = dto.fromsymbol,
        tosymbol = dto.tosymbol,
        lastmarket = dto.lastmarket,
        price = dto.price,
        lastupdate = dto.lastupdate,
        highday = dto.highday,
        lowday = dto.lowday,
        imageurl = dto.imageurl
    )

    fun mapJsonContainerToListCoinInfoDto(jsonContainer: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesListDto: CoinNamesListDto): String {
        return namesListDto.names?.map { it.coinNameDto?.name }?.joinToString(",") ?: ""
    }

    fun mapDbModelToEntity(dbModel: CoinInfoDbModel) = CoinInfo(
        fromsymbol = dbModel.fromsymbol,
        tosymbol = dbModel.tosymbol,
        lastmarket = dbModel.lastmarket,
        price = dbModel.price,
        lastupdate = dbModel.lastupdate,
        highday = dbModel.highday,
        lowday = dbModel.lowday,
        imageurl = dbModel.imageurl
    )
}