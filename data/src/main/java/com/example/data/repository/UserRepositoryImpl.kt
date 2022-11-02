package com.example.data.repository

import com.example.data.component.UserComponentManager
import com.example.data.entrypoint.UserEntryPoint
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import dagger.hilt.EntryPoints
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userComponentManager: UserComponentManager
) : UserRepository {

    override fun getUser(): Flow<User?> = flow {
        val user = EntryPoints
            .get(userComponentManager, UserEntryPoint::class.java)
            .provideUser()
        emit(user)
    }
}