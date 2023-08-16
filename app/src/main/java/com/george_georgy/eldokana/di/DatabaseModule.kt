package com.george_georgy.eldokana.di

import androidx.room.Room
import com.george_georgy.eldokana.feature_wishlist.data.local.WishlistDatabase
import com.george_georgy.eldokana.feature_wishlist.data.repository.WishlistRepositoryImpl
import com.george_georgy.eldokana.feature_wishlist.data.util.Converters
import com.george_georgy.eldokana.feature_wishlist.domain.repository.WishlistRepository
import com.george_georgy.eldokana.feature_wishlist.presentaion.WishlistViewModel
import com.george_georgy.eldokana.feature_wishlist.util.Constant.WISHLIST_DATABASE
import com.google.gson.Gson
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get(),
            WishlistDatabase::class.java,
            WISHLIST_DATABASE
        ).addTypeConverter(Converters(Gson()))
            .fallbackToDestructiveMigration()
            .build()
    }



    single<WishlistRepository> {
        WishlistRepositoryImpl(get())
    }

    viewModel {
        WishlistViewModel(get())
    }
}