package com.wayne.porttotask.di

import com.wayne.porttotask.data.repository.OpenseaRepository
import com.wayne.porttotask.data.repository.OpenseaRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<OpenseaRepository> {
        OpenseaRepositoryImpl()
    }
}
