package com.yjh.dt.dailytools.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.yjh.dt.dailytools.R
import com.yjh.dt.dailytools.di.component.DaggerExchangeComponent
import com.yjh.dt.dailytools.di.module.ExchangeModule
import com.yjh.dt.dailytools.model.Currency
import com.yjh.dt.dailytools.retrofit.Resource
import com.yjh.dt.dailytools.view.base.BaseFragment
import com.yjh.dt.dailytools.viewmodel.ExchangeViewModel
import javax.inject.Inject

class ExchangeFragment: BaseFragment() {

    @Inject
    lateinit var viewModel: ExchangeViewModel

    companion object {
        fun newInstance() = ExchangeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exchange_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        DaggerExchangeComponent.builder().exchangeModule(ExchangeModule(activity!!.application)).build().inject(this)
        viewModel.currencyList.observe(this, Observer {
            setCurrencyList(it);
        })
    }

    private fun setCurrencyList(currencyList: Resource<List<Currency>>) {
        Log.d("TEST123", currencyList.toString());
    }
}
