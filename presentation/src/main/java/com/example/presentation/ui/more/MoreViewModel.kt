package com.example.presentation.ui.more

import androidx.lifecycle.ViewModel
import com.example.domain.Bridged
import com.example.presentation.delegate.SignInViewModelDelegate
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoreViewModel @Inject constructor(
    @Bridged signInViewModelDelegate: SignInViewModelDelegate
) : ViewModel(), SignInViewModelDelegate by signInViewModelDelegate {

}