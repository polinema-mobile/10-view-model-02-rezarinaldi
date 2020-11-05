package com.rezarinaldi.mvvmlogin.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rezarinaldi.mvvmlogin.R
import com.rezarinaldi.mvvmlogin.databinding.FragmentLoginBinding
import com.rezarinaldi.mvvmlogin.models.Pengguna
import com.rezarinaldi.mvvmlogin.viewmodels.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var mPengguna: Pengguna

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.penggunaLiveData.observe(viewLifecycleOwner, { value ->
            Log.e("observePengguna", value.email + " " + value.password)
            mPengguna = value
            Log.e("mPengguna", mPengguna.email + " " + mPengguna.password)
        })

        viewModel.loggedLiveData.observe(viewLifecycleOwner, { value ->
            if (value) {
                Toast.makeText(context, "Login sukses!", Toast.LENGTH_SHORT).show()
                val bundle = bundleOf("email" to mPengguna.email)
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
            }
        })
    }
}