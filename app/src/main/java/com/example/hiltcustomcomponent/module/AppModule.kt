package com.example.hiltcustomcomponent.module

import com.example.data.component.UserComponentManager
import com.example.domain.Bridged
import com.example.domain.repository.UserRepository
import com.example.domain.service.UserService
import com.example.presentation.delegate.SignInViewModelDelegate
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BridgeModule {

    @Bridged
    @Provides
    fun provideUserService(
        userComponentManager: UserComponentManager
    ): UserService {
        return EntryPoints.get(
            userComponentManager, UserComponentBridge::class.java
        ).provideUserService()
    }

    @Bridged
    @Provides
    fun provideUserRepository(
        userComponentManager: UserComponentManager
    ): UserRepository {
        return EntryPoints.get(
            userComponentManager, UserComponentBridge::class.java
        ).provideUserRepository()
    }

    @Bridged
    @Provides
    fun provideSignInViewModelDelegate(
        userComponentManager: UserComponentManager
    ): SignInViewModelDelegate {
        return EntryPoints.get(
            userComponentManager, UserComponentBridge::class.java
        ).provideSignInViewModelDelegate()
    }
}