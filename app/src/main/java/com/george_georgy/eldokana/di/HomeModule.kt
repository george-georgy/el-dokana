package com.george_georgy.eldokana.di

import com.george_georgy.eldokana.feature_home_products.data.remote.HomeApi
import com.george_georgy.eldokana.feature_home_products.data.remote.HomeApiImpl
import com.george_georgy.eldokana.feature_home_products.data.remote.repository.HomeRepositoryImpl
import com.george_georgy.eldokana.feature_home_products.domain.repository.HomeRepository
import com.george_georgy.eldokana.feature_home_products.domain.use_case.GetCategoriesUseCase
import com.george_georgy.eldokana.feature_home_products.domain.use_case.GetProductsUseCase
import com.george_georgy.eldokana.feature_home_products.presentation.home_lists.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single<HomeApi>{
        HomeApiImpl(get())
    }

    // HomeRepository Repository instance
    single<HomeRepository> {
        HomeRepositoryImpl(get())
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




}
