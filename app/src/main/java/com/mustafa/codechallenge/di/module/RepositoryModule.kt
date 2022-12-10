package com.mustafa.codechallenge.di.module

import com.mustafa.codechallenge.data.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        MainRepository(get())
    }
}