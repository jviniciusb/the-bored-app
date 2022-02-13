package com.jviniciusb.theboredapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jviniciusb.theboredapp.domain.mapper.asUi
import com.jviniciusb.theboredapp.domain.usecase.GetActivityUseCase
import com.jviniciusb.theboredapp.ui.model.ActivityUi
import com.jviniciusb.theboredapp.ui.model.BoredEvent
import kotlinx.coroutines.launch

class BoredViewModel(private val getActivity: GetActivityUseCase) : ViewModel() {

    private val _activity = MutableLiveData<Result<ActivityUi>>()
    val activity: LiveData<Result<ActivityUi>>
        get() = _activity

    fun handleBoredEvent(event: BoredEvent) = when (event) {

        BoredEvent.LoadActivity -> {
            loadActivity()
        }
    }

    private fun loadActivity() {

        viewModelScope.launch {

            getActivity()?.let {
                _activity.postValue(Result.success(it.asUi()))
            } ?: run {
                _activity.postValue(Result.failure(IllegalStateException()))
            }
        }
    }
}
