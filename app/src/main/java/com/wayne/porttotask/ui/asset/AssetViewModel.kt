package com.wayne.porttotask.ui.asset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wayne.porttotask.data.remote.OpenseaService
import com.wayne.porttotask.data.vo.Asset
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AssetViewModel() : ViewModel(), KoinComponent {
    private val openseaService: OpenseaService by inject()

    private val _asset = MutableLiveData<Asset>()
    val asset: LiveData<Asset> = _asset

    suspend fun fetchAsset(contractAddress: String, tokenId: String): LiveData<Asset> {
        val response = openseaService.retrievingAsset(contractAddress, tokenId)
        _asset.value = response
        return asset
    }
}
