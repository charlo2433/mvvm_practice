package com.verus.mvvm_prac.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.verus.mvvm_prac.data.repository.AuthRepository
import com.verus.mvvm_prac.data.repository.BaseRepository
import com.verus.mvvm_prac.ui.auth.AuthViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) ->AuthViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}