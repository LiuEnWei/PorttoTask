package com.wayne.porttotask.ui.asset

import android.net.Uri
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.wayne.porttotask.R
import com.wayne.porttotask.databinding.FragmentAssetBinding
import com.wayne.porttotask.extensions.startActivity
import com.wayne.porttotask.ui.base.BaseFragment
import kotlinx.coroutines.launch

class AssetFragment : BaseFragment<FragmentAssetBinding>(R.layout.fragment_asset) {

    private val viewModel by viewModels<AssetViewModel>()
    private val args : AssetFragmentArgs by navArgs()

    override fun bindView(view: View): FragmentAssetBinding {
        return FragmentAssetBinding.bind(view)
    }

    override fun init() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchAsset(args.contractAddress, args.tokenId).observe(
                viewLifecycleOwner,
                Observer { asset ->
                    (requireActivity() as AppCompatActivity).supportActionBar?.title = asset.collection?.name
                    binding?.let { binding ->
                        Glide.with(binding.imageAsset.context).load(asset.imageUrl).into(binding.imageAsset)
                        val permalink = asset.permalink
                        if (!permalink.isNullOrEmpty()) {
                            binding.buttonPermalink.setOnClickListener {
                                startActivity(Uri.parse(permalink))
                            }
                        }
                        binding.textName.text = asset.name
                        binding.textDescription.text = asset.description
                    }
                })
        }
    }
}
