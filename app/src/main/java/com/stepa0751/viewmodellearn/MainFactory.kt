package com.stepa0751.viewmodellearn

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainFactory(val application: Application, val text: String, val chislo: Int):
ViewModelProvider.AndroidViewModelFactory(application){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(application, text, chislo) as T
    }
}