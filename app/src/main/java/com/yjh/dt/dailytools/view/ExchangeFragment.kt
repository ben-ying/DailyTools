package com.yjh.dt.dailytools.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yjh.dt.dailytools.R
import com.yjh.dt.dailytools.view.base.BaseFragment
import com.yjh.dt.dailytools.viewmodel.ExchangeViewModel

class ExchangeFragment : BaseFragment() {

    companion object {
        fun newInstance() = ExchangeFragment()
    }

    private lateinit var viewModel: ExchangeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exchange_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExchangeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
