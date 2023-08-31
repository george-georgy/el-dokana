package com.george_georgy.eldokana.di

import com.george_georgy.eldokana.feature_home_products.data.remote.HomeApi
import com.george_georgy.eldokana.feature_home_products.data.remote.HomeApiImpl
import com.george_georgy.eldokana.feature_home_products.data.remote.repository.HomeRepositoryImpl
import com.george_georgy.eldokana.feature_home_products.domain.repository.HomeRepository
import com.george_georgy.eldokana.feature_home_products.domain.use_case.GetCategoriesUseCase
import com.george_georgy.eldokana.feature_home_products.domain.use_case.GetProductsUseCase
import com.george_georgy.eldokana.feature_home_products.presentation.home_lists.HomeViewModel
import com.george_georgy.eldokana.feature_profile.data.repository.ProfileRepository
import com.george_georgy.eldokana.feature_profile.presentation.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single<HomeApi>{
        HomeApiImpl(get())
    }

    // HomeRepository  instance
    single<HomeRepository> {
        HomeRepositoryImpl(get())
    }

    // ProfileRepository  instance
    single {
        ProfileRepository(get())
    }

    // GetCategoriesUseCase instance
    single {
        GetCategoriesUseCase(get())
    }

    // GetProductsUseCase instance
    single {
        GetProductsUseCase(get())
    }

    // CategoryViewModel instance
    viewModel {
        HomeViewModel(get(), get())
    }

    // profileViewModel instance
    viewModel {
        ProfileViewModel(get(),get())
    }




}
