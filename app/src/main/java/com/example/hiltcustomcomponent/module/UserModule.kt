package com.example.hiltcustomcomponent.module

import com.example.data.component.UserComponent
import com.example.data.scope.UserScope
import com.example.domain.repository.UserRepository
import com.example.domain.service.UserService
import com.example.presentation.delegate.SignInViewModelDelegate
import com.example.presentation.delegate.SignInViewModelDelegateImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@Module
@InstallIn(UserComponent::class)
internal interface UserModule {

    @Binds
    @UserScope
    fun bindSignInViewModelDelegate(signInViewModelDelegate: SignInViewModelDelegateImpl): SignInViewModelDelegate
}

@EntryPoint
@InstallIn(UserComponent::class)
internal interface UserComponentBridge {
    fun provideUserService(): UserService
    fun provideUserRepository(): UserRepository
    fun provideSignInViewModelDelegate(): SignInViewModelDelegate
}