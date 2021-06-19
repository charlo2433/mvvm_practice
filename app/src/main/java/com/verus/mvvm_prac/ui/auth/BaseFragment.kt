package com.verus.mvvm_prac.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.verus.mvvm_prac.data.network.RemoteDataSource
import com.verus.mvvm_prac.data.repository.BaseRepository
import com.verus.mvvm_prac.ui.base.ViewModelFactory

abstract class BaseFragment<VM: ViewModel, B: ViewBinding, R: BaseRepository >: Fragment() {

    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    protected val remoteDataSource = RemoteDataSource()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel() )
        return binding.root
    }

    abstract fun getViewModel() : Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun getFragmentRepository(): R

}