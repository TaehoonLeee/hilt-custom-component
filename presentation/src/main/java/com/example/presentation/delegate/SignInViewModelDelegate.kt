package com.example.presentation.delegate

import com.example.domain.Bridged
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

interface SignInViewModelDelegate {
    val user: StateFlow<User?>
}

class SignInViewModelDelegateImpl @Inject constructor(
    @Bridged userRepository: UserRepository
) : SignInViewModelDelegate {

    override val user = userRepository.getUser()
        .stateIn(CoroutineScope(Dispatchers.Default), SharingStarted.WhileSubscribed(5000), null)

}