package com.jviniciusb.theboredapp.network

import com.jviniciusb.theboredapp.domain.model.Activity
import retrofit2.Response
import retrofit2.http.GET

interface BoredApiClient {

    @GET("activity")
    suspend fun getActivity(): Response<Activity>
}
