package com.example.presentation.ui.main

import androidx.lifecycle.ViewModel
import com.example.domain.Bridged
import com.example.domain.service.UserService
import com.example.presentation.delegate.SignInViewModelDelegate
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @Bridged private val userService: UserService,
    @Bridged signInViewModelDelegate: SignInViewModelDelegate
) : ViewModel(), SignInViewModelDelegate by signInViewModelDelegate {

    fun onLogout() {
        userService.logout()
    }
}