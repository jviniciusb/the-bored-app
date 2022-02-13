package com.jviniciusb.theboredapp.domain.mapper

import com.jviniciusb.theboredapp.domain.model.Activity
import com.jviniciusb.theboredapp.ui.model.ActivityUi

fun Activity.asUi() = ActivityUi(
    activity = activity,
    type = type,
    participants = participants,
    link = link,
)
