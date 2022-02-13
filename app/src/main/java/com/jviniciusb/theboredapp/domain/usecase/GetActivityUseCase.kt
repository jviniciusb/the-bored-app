package com.jviniciusb.theboredapp.domain.usecase

import com.jviniciusb.theboredapp.domain.model.Activity

interface GetActivityUseCase {

    suspend operator fun invoke(): Activity?
}
