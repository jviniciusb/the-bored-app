package com.jviniciusb.theboredapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jviniciusb.theboredapp.R
import com.jviniciusb.theboredapp.databinding.ActivityBoredBinding
import com.jviniciusb.theboredapp.ui.model.ActivityUi
import com.jviniciusb.theboredapp.ui.model.BoredEvent
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton
import org.koin.androidx.viewmodel.ext.android.viewModel

class BoredActivity : AppCompatActivity() {

    private val boredViewModel by viewModel<BoredViewModel>()

    private lateinit var binding: ActivityBoredBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBoredBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
        setupObservers()
        showEmptyState()
    }

    private fun setupListeners() {

        binding.buttonGetActivity.setOnClickListener {
            onGetActivityPressed()
        }
    }

    private fun setupObservers() {

        boredViewModel.activity.observe(this) { result ->
            result ?: return@observe

            result.getOrNull()?.let { activity ->
                showSuccessSate(activity)
            } ?: run {
                showErrorState()
            }
        }
    }

    private fun onGetActivityPressed() {
        togleLoadingState(isLoading = true)
        boredViewModel.handleBoredEvent(BoredEvent.LoadActivity)
    }

    private fun showSuccessSate(activityUi: ActivityUi) {

        togleLoadingState()

        binding.textViewActivityNameValue.text = activityUi.activity.ifEmpty { "--" }
        binding.textViewActivityTypeValue.text = activityUi.type.ifEmpty { "--" }
        binding.textViewActivityParticipantsValue.text = activityUi.participants.toString()
        binding.textViewActivityLinkValue.text = activityUi.link.ifEmpty { "--" }
    }

    private fun showEmptyState() {

        togleLoadingState()

        binding.textViewActivityNameValue.text = "--"
        binding.textViewActivityTypeValue.text = "--"
        binding.textViewActivityLinkValue.text = "--"
        binding.textViewActivityParticipantsValue.text = "--"
    }

    private fun showErrorState() {
        togleLoadingState()
        Toast.makeText(baseContext, R.string.error, Toast.LENGTH_SHORT).show()
    }

    private fun togleLoadingState(isLoading: Boolean = false) = if (isLoading) {
        binding.linearLayoutActivity.loadSkeleton()
    } else {
        binding.linearLayoutActivity.hideSkeleton()
    }
}
