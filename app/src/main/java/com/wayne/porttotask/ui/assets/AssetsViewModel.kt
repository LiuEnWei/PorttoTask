package com.wayne.porttotask.ui.assets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.wayne.porttotask.data.repository.AssetsRepository
import com.wayne.porttotask.data.vo.Asset
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AssetsViewModel() : ViewModel(), KoinComponent {
    private val assetsRepository: AssetsRepository by inject()
    private val _assetsList = MutableLiveData<PagingData<Asset>>()

    suspend fun fetchAssetsPagingData(): LiveData<PagingData<Asset>> {
        val response = assetsRepository.getAssets().cachedIn(viewModelScope)
        _assetsList.value = response.value
        return response
    }
}
