package com.wayne.porttotask.ui.assets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wayne.porttotask.data.vo.Asset
import com.wayne.porttotask.databinding.ItemAssetBinding

class AssetsAdapter(private val itemClickListener: OnItemClickListener) :
    PagingDataAdapter<Asset, AssetsAdapter.ViewHolder>(DiffUtilCallBack) {

    interface OnItemClickListener {
        fun onItemClick(itemData: Asset)
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<Asset>() {
        override fun areItemsTheSame(oldItem: Asset, newItem: Asset): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Asset, newItem: Asset): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAssetBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class ViewHolder(private val binding: ItemAssetBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val itemData = getItem(absoluteAdapterPosition)
                itemData?.let {
                    itemClickListener.onItemClick(it)
                }
            }
        }

        fun bind(item: Asset) {
            Glide.with(binding.imageAsset.context).load(item.imageUrl).into(binding.imageAsset)
            binding.textName.text = item.name
        }
    }
}
