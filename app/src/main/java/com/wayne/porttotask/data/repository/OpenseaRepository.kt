package com.wayne.porttotask.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.wayne.porttotask.Constant
import com.wayne.porttotask.data.paging.AssetsPagingDataSource
import com.wayne.porttotask.data.remote.OpenseaService
import com.wayne.porttotask.data.vo.Asset
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface OpenseaRepository {
    fun getAssets(): LiveData<PagingData<Asset>>
    suspend fun retrievingAsset(contractAddress: String, tokenId: String): Asset?
}

class OpenseaRepositoryImpl(): OpenseaRepository, KoinComponent {
    private val api: OpenseaService by inject()

    override fun getAssets(): LiveData<PagingData<Asset>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constant.LIMIT
            ),
            pagingSourceFactory = {
                AssetsPagingDataSource()
            }
        ).liveData
    }

    override suspend fun retrievingAsset(contractAddress: String, tokenId: String): Asset? {
        return try {
            api.retrievingAsset(contractAddress, tokenId)
        } catch (e: Exception) {
            null
        }
    }
}
