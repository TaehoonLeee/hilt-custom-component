package com.example.data.entrypoint

import com.example.data.component.UserComponent
import com.example.domain.model.User
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@EntryPoint
@InstallIn(UserComponent::class)
interface UserEntryPoint {
    fun provideUser(): User?
}