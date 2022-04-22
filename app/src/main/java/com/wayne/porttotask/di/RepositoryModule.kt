package com.wayne.porttotask.di

import com.wayne.porttotask.data.repository.AssetsRepository
import com.wayne.porttotask.data.repository.AssetsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<AssetsRepository> {
        AssetsRepositoryImpl()
    }
}