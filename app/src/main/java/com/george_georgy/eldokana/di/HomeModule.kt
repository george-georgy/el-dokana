package com.george_georgy.eldokana.di

import com.george_georgy.eldokana.feature_auth.data.remote.AuthApi
import com.george_georgy.eldokana.feature_auth.data.remote.AuthImpl
import com.george_georgy.eldokana.feature_auth.data.repository.AuthRepositoryImpl
import com.george_georgy.eldokana.feature_auth.domain.repository.AuthRepository
import com.george_georgy.eldokana.feature_auth.domain.use_case.signing.LoginUseCase
import com.george_georgy.eldokana.feature_home_products.data.remote.HomeApi
import com.george_georgy.eldokana.feature_home_products.data.remote.HomeApiImpl
import com.george_georgy.eldokana.feature_home_products.data.remote.repository.HomeRepositoryImpl
import com.george_georgy.eldokana.feature_home_products.domain.repository.HomeRepository
import com.george_georgy.eldokana.feature_home_products.domain.use_case.GetCategoriesUseCase
import com.george_georgy.eldokana.feature_home_products.domain.use_case.GetProductsUseCase
import com.george_georgy.eldokana.feature_home_products.presentation.category.CategoryViewModel
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
    single {
        CategoryViewModel(get())
    }




}
