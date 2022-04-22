package com.wayne.porttotask.ui.assets

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.wayne.porttotask.R
import com.wayne.porttotask.data.vo.Asset
import com.wayne.porttotask.databinding.FragmentAssetsBinding
import com.wayne.porttotask.ui.base.BaseFragment
import kotlinx.coroutines.launch

class AssetsFragment :
    BaseFragment<FragmentAssetsBinding>(R.layout.fragment_assets),
    AssetsAdapter.OnItemClickListener {

    private val viewModel by viewModels<AssetsViewModel>()

    private val assetsAdapter by lazy {
        AssetsAdapter(this)
    }

    override fun bindView(view: View): FragmentAssetsBinding {
        return FragmentAssetsBinding.bind(view)
    }

    override fun init() {
        binding?.listAssets?.adapter = assetsAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchAssetsPagingData().observe(
                viewLifecycleOwner,
                Observer {
                    assetsAdapter.submitData(lifecycle, it)

                })
        }
    }

    override fun onItemClick(itemData: Asset) {
        val contractAddress = itemData.assetContract?.address
        val tokenId = itemData.tokenId
        if (contractAddress.isNullOrEmpty() || tokenId.isNullOrEmpty()) {
            return
        }
        findNavController().navigate(AssetsFragmentDirections.actionAssetsToAsset(contractAddress, tokenId))
    }
}
