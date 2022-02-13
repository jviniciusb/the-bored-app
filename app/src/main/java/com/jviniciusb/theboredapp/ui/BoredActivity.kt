package com.jviniciusb.theboredapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jviniciusb.theboredapp.R
import com.jviniciusb.theboredapp.databinding.ActivityBoredBinding
import com.jviniciusb.theboredapp.ui.model.ActivityUi
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton

class BoredActivity : AppCompatActivity() {

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
        TODO("Not yet implemented")
    }

    private fun onGetActivityPressed() {
        TODO("Add call to viewModel")
        togleLoadingState(isLoading = true)
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
