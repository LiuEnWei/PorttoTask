package com.wayne.porttotask.ui.assets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.wayne.porttotask.data.repository.AssetsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AssetsViewModel() : ViewModel(), KoinComponent {
    private val assetsRepository: AssetsRepository by inject()
    val assetsList = assetsRepository.getAssets().cachedIn(viewModelScope)
}
