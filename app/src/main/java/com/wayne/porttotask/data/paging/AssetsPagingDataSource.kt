package com.wayne.porttotask.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.wayne.porttotask.Constant
import com.wayne.porttotask.data.remote.OpenseaService
import com.wayne.porttotask.data.vo.Asset
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AssetsPagingDataSource : PagingSource<Int, Asset>(), KoinComponent {

    private val api: OpenseaService by inject()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Asset> {
        return try {
            val offset = params.key ?: 0
            val response = api.getAssets(
                offset = offset
            )
            val assets = response.assets
            if (assets.isNullOrEmpty()) {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            } else {
                LoadResult.Page(
                    data = assets,
                    prevKey = null,
                    nextKey = offset + Constant.LIMIT
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Asset>): Int? {
        return null
    }
}