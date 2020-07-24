package com.yjh.dt.dailytools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yjh.dt.dailytools.repository.ExchangeRepository
import com.yjh.dt.dailytools.model.Currency
import com.yjh.dt.dailytools.retrofit.Resource
import javax.inject.Inject

class ExchangeViewModel @Inject constructor(
//    saveStateHandle: SavedStateHandle,
    exchangeRepository: ExchangeRepository
) : ViewModel() {
    val currencyList: LiveData<Resource<List<Currency>>> = exchangeRepository.getCurrencyList()
}
