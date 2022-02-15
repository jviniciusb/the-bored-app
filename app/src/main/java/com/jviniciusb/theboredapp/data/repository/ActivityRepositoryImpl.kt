package com.jviniciusb.theboredapp.data.repository

import com.jviniciusb.theboredapp.data.datasource.ActivityRemoteDataSource
import com.jviniciusb.theboredapp.domain.model.Activity

class ActivityRepositoryImpl(
    private val activityRemoteDataSource: ActivityRemoteDataSource
) : ActivityRepository {

    override suspend fun getActivity(): Activity? = activityRemoteDataSource.getActivity()
}
