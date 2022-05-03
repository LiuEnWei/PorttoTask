package com.wayne.porttotask.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.wayne.porttotask.Constant
import com.wayne.porttotask.data.paging.AssetsPagingDataSource
import com.wayne.porttotask.data.vo.Asset

interface AssetsRepository {
    fun getAssets(): LiveData<PagingData<Asset>>
}

class AssetsRepositoryImpl(): AssetsRepository {
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
}
