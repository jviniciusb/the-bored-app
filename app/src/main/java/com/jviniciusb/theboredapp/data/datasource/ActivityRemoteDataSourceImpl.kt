package com.jviniciusb.theboredapp.data.datasource

import android.util.Log
import com.jviniciusb.theboredapp.domain.model.Activity
import com.jviniciusb.theboredapp.network.BoredApiClient
import java.io.IOException

class ActivityRemoteDataSourceImpl(
    private val boredApiClient: BoredApiClient
) : ActivityRemoteDataSource {

    override suspend fun getActivity(): Activity? {

        return try {
            val response = boredApiClient.getActivity()
            if (response.isSuccessful) {
                response.body()
            } else {
                throw IOException("${response.errorBody()}")
            }
        } catch (t: Throwable) {
            Log.e("Error: ", "${t.message}")
            null
        }
    }
}
