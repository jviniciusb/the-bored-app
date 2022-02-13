package com.jviniciusb.theboredapp.data.datasource

import com.jviniciusb.theboredapp.domain.model.Activity

interface ActivityRemoteDataSource {

    suspend fun getActivity(): Activity?
}
