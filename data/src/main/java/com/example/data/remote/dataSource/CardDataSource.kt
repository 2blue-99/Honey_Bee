package com.example.data.remote.dataSource

import ServerResponse
import com.example.data.remote.model.ServerCardResponse
import com.example.domain.model.receive.CardData
import com.example.domain.model.receive.ResponseData
import retrofit2.http.*

/**
 * 2023-07-23
 * pureum
 */
interface CardDataSource {

    @FormUrlEncoded
    @POST("billCard/add")
    suspend fun sendCardDataSource(
        @Field("cardName") cardName : String?,
        @Field("cardAmount") amount : Int?,
        @Field("billCheckDate") billCheckDate : String?
    ): ServerResponse<String>

    @Streaming
    @GET("billCard/list")
    suspend fun getCardDataSource() : ServerResponse<List<ServerCardResponse>>

//    //아직 안쓰이는 기능
//    @DELETE("billCard/delete/{uid}")
//    suspend fun deleteCardDataSource(
//        @Path("uid") uid:Long
//    ): ServerResponse<SimpleResponse>
//
//    //아직 안쓰이는 기능
//    @FormUrlEncoded
//    @PUT("billCard/update/{id}")
//    suspend fun updateCardDataSource(
//        @Path("id") id: Long,
//        @Field("cardName") cardName : String,
//        @Field("cardAmount") cardAmount : Int
//    ): ServerResponse<SimpleResponse>
}