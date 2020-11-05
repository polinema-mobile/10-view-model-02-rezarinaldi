package com.rezarinaldi.mvvmlogin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rezarinaldi.mvvmlogin.models.Pengguna

class LoginViewModel : ViewModel() {
    var pengguna: Pengguna = Pengguna()
    private var penggunaDummy: Pengguna = Pengguna()
    private var loggedIn: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private var penggunaMutable = MutableLiveData<Pengguna>()
    private var emailSalah: MutableLiveData<String> = MutableLiveData<String>()
    private var passwordSalah: MutableLiveData<String> = MutableLiveData<String>()

    val loggedLiveData: LiveData<Boolean>
        get() = loggedIn
    val penggunaLiveData: LiveData<Pengguna>
        get() = penggunaMutable
    val emailSalahLiveData: LiveData<String>
        get() = emailSalah
    val passwordSalahLiveData: LiveData<String>
        get() = passwordSalah

    init {
        loggedIn.value = false
        penggunaMutable.value = Pengguna()
        penggunaDummy.email = "rezar@gmail.com"
        penggunaDummy.password = "apahayoo"
    }

    fun cekLogin() {
        if (pengguna.email.isEmpty()) {
            emailSalah.value = "Email masih kosong"
        }
        if (pengguna.password.isEmpty()) {
            passwordSalah.value = "Password masih kosong"
        }
        if (pengguna.email.isNotEmpty() || pengguna.password.isNotEmpty()) {
            if (pengguna.email.equals(penggunaDummy.email) and pengguna.password.equals(penggunaDummy.password)) {
                loggedIn.value = true
                penggunaMutable.value = pengguna
            } else {
                emailSalah.value = "Email masih salah"
                passwordSalah.value = "Password masih salah"
            }
        }
    }
}