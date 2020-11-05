package com.rezarinaldi.mvvmlogin.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rezarinaldi.mvvmlogin.R
import com.rezarinaldi.mvvmlogin.databinding.FragmentSplashBinding
import com.rezarinaldi.mvvmlogin.models.Splash
import com.rezarinaldi.mvvmlogin.viewmodels.SplashViewModel
import com.rezarinaldi.mvvmlogin.viewmodels.SplashViewModelFactory

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private lateinit var viewModel: SplashViewModel
    private lateinit var splash: Splash

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        splash = Splash(imgSplash = R.drawable.splash_mdm, txtSplash = "Madrasah Darul Muta’allimin")
        viewModel = ViewModelProvider(this, SplashViewModelFactory(splash = splash)).get(SplashViewModel::class.java)

        binding.splashViewModel = viewModel
        binding.lifecycleOwner = this
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }, 3000)

        return binding.root
    }
}