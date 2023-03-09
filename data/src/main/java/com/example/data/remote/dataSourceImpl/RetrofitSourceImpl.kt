package com.example.data.remote.dataSourceImpl

import com.example.data.remote.dataSource.RetrofitSource
import com.example.data.remote.dto.ReceiveData
import com.example.data.remote.dto.SendData
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import java.time.LocalDateTime
import javax.inject.Inject

/**
 * 2023-02-02
 * pureum
 */
class RetrofitSourceImpl @Inject constructor(
    private val retrofit: Retrofit,
):RetrofitSource{


    override suspend fun sendDataSource(card:String, amount:Int, pictureName:String, date:LocalDateTime, bill:MultipartBody.Part): SendData {

//        return retrofit.create(RetrofitSource::class.java).sendDataSource(card = card, date = date, amount = amount, pictureName = "hello")
        return retrofit.create(RetrofitSource::class.java).sendDataSource(card = card, amount = amount, pictureName="ㄹㅇㄴㄹㄴㅇㄹㄴㅁ", date = date, bill = bill)
    }

    override suspend fun receiveDataSource(): ReceiveData {
        return retrofit.create(RetrofitSource::class.java).receiveDataSource()
    }

    override suspend fun test(a:String):String {
        return retrofit.create(RetrofitSource::class.java).test("a")
    }
}