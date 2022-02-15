package com.jviniciusb.theboredapp.domain.usecase

import com.jviniciusb.theboredapp.data.repository.ActivityRepository
import com.jviniciusb.theboredapp.domain.model.Activity

class GetActivityUseCaseImpl(
    private val activityRepository: ActivityRepository
) : GetActivityUseCase {

    override suspend fun invoke(): Activity? = activityRepository.getActivity()
}
