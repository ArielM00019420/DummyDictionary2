package com.flores.dummydictionary.ui.word

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flores.dummydictionary.WordViewModel
import com.flores.dummydictionary.repository.DictionaryRepository
import com.flores.dummydictionary.repository.LoginRepository
import com.flores.dummydictionary.ui.login.LoginViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory<R>(private val repository: R) :
    ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
                return WordViewModel(repository as DictionaryRepository) as T
            }
            if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                return LoginViewModel(repository as LoginRepository) as T
            }
            throw  IllegalArgumentException("Unkown Viewmodel Class")
        }
}