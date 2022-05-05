package com.wayne.porttotask.ui.asset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wayne.porttotask.data.remote.OpenseaService
import com.wayne.porttotask.data.repository.OpenseaRepository
import com.wayne.porttotask.data.vo.Asset
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AssetViewModel() : ViewModel(), KoinComponent {
    private val openseaRepository: OpenseaRepository by inject()

    private val _asset = MutableLiveData<Asset>()
    val asset: LiveData<Asset> = _asset

    suspend fun fetchAsset(contractAddress: String, tokenId: String): LiveData<Asset> {
        val response = openseaRepository.retrievingAsset(contractAddress, tokenId)
        response?.let {
            _asset.value = it
        }
        return asset
    }
}
