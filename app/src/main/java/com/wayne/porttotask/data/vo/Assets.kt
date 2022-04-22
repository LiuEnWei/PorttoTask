package com.wayne.porttotask.data.vo

import com.google.gson.annotations.SerializedName

data class Assets(
    @SerializedName("assets")
    val assets: List<Asset>?
)
