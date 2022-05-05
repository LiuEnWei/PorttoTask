package com.wayne.porttotask.ui.assets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.wayne.porttotask.data.repository.OpenseaRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AssetsViewModel() : ViewModel(), KoinComponent {
    private val openseaRepository: OpenseaRepository by inject()
    val assetsList = openseaRepository.getAssets().cachedIn(viewModelScope)
}
