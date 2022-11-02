package com.example.data.module

import com.example.data.component.UserComponent
import com.example.data.repository.UserRepositoryImpl
import com.example.data.scope.UserScope
import com.example.data.service.UserServiceImpl
import com.example.domain.repository.UserRepository
import com.example.domain.service.UserService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn

@Module
@InstallIn(UserComponent::class)
internal interface UserModule {

    @Binds
    @UserScope
    fun bindUserRepository(userRepository: UserRepositoryImpl): UserRepository

    @Binds
    @UserScope
    fun bindUserService(userService: UserServiceImpl): UserService
}