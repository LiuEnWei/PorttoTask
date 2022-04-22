package com.wayne.porttotask.data.vo

import com.google.gson.annotations.SerializedName

data class Asset(
    @SerializedName("id")
    val id: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("asset_contract")
    val assetContract: AssetContract?,
    @SerializedName("permalink")
    val permalink: String?,
    @SerializedName("collection")
    val collection: Collection?,
    @SerializedName("token_id")
    val tokenId: String?
)
