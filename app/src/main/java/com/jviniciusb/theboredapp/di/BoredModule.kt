package com.jviniciusb.theboredapp.di

import com.jviniciusb.theboredapp.data.datasource.ActivityRemoteDataSource
import com.jviniciusb.theboredapp.data.datasource.ActivityRemoteDataSourceImpl
import com.jviniciusb.theboredapp.data.repository.ActivityRepository
import com.jviniciusb.theboredapp.data.repository.ActivityRepositoryImpl
import com.jviniciusb.theboredapp.domain.usecase.GetActivityUseCase
import com.jviniciusb.theboredapp.domain.usecase.GetActivityUseCaseImpl
import com.jviniciusb.theboredapp.network.ApiClientFactory
import com.jviniciusb.theboredapp.network.BoredApiClient
import com.jviniciusb.theboredapp.ui.BoredViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object BoredModule {

    private const val BORED_API_BASE_URL_KEY = "BORED_API_BASE_URL"

    val module = module {

        factory<BoredApiClient> {
            ApiClientFactory.createClient(
                getProperty(
                    BORED_API_BASE_URL_KEY
                )
            )
        }
        factory<ActivityRemoteDataSource> { ActivityRemoteDataSourceImpl(get()) }
        factory<ActivityRepository> { ActivityRepositoryImpl(get()) }
        factory<GetActivityUseCase> { GetActivityUseCaseImpl(get()) }

        viewModel { BoredViewModel(get()) }
    }
}
