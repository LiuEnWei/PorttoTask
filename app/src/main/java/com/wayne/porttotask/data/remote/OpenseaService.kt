package com.wayne.porttotask.data.remote

import com.wayne.porttotask.Constant
import com.wayne.porttotask.data.vo.Asset
import com.wayne.porttotask.data.vo.Assets
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenseaService {
    @Headers(Constant.OPENSEA_HEADERS)
    @GET("/api/v1/assets")
    suspend fun getAssets(
        @Query("format")
        format: String = Constant.FORMAT,
        @Query("owner")
        owner: String = Constant.OWNER,
        @Query("offset")
        offset: Int,
        @Query("limit")
        limit: Int = Constant.LIMIT
    ): Assets

    @Headers(Constant.OPENSEA_HEADERS)
    @GET("/api/v1/asset/{contractAddress}/{tokenId}")
    suspend fun retrievingAsset(
        @Path("contractAddress")
        contractAddress: String,
        @Path("tokenId")
        tokenId: String
    ): Asset
}
