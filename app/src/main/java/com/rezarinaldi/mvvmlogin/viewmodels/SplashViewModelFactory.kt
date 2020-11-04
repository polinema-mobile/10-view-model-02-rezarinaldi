package com.rezarinaldi.mvvmlogin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rezarinaldi.mvvmlogin.models.Splash

class SplashViewModelFactory(private var splash: Splash) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(splash = splash) as T
        }
        throw IllegalArgumentException("Wrong ViewModel class")
    }
}