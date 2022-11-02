package com.example.data.service

import com.example.data.component.UserComponentManager
import com.example.domain.model.User
import com.example.domain.service.UserService
import javax.inject.Inject

class UserServiceImpl @Inject constructor(
    private val userComponentManager: UserComponentManager
) : UserService {
    override fun login(): String {
        val token = "token"
        userComponentManager.onLogin(User(token))

        return token
    }

    override fun logout() {
        userComponentManager.onLogout()
    }
}