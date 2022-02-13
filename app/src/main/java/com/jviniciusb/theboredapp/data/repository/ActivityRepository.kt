package com.jviniciusb.theboredapp.data.repository

import com.jviniciusb.theboredapp.domain.model.Activity

interface ActivityRepository {

    suspend fun getActivity(): Activity?
}
