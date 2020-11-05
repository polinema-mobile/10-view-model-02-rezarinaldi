package com.rezarinaldi.mvvmlogin.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.rezarinaldi.mvvmlogin.BR

class Pengguna : BaseObservable() {
    @Bindable
    var email: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }
    get() = field

    @Bindable
    var password: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.password)
        }
    get() = field
}