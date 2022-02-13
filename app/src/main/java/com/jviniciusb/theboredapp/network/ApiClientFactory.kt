package com.jviniciusb.theboredapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientFactory {

    inline fun <reified TClient> createClient(clientBaseUrl: String): TClient = Retrofit.Builder()
        .baseUrl(clientBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient().newBuilder().build())
        .build().create(TClient::class.java)
}
