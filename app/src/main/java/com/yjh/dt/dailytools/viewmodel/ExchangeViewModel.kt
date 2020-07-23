package com.yjh.dt.dailytools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.yjh.dt.dailytools.repository.ExchangeRepository
import com.yjh.dt.dailytools.room.Currency
import javax.inject.Inject

class ExchangeViewModel @Inject constructor(
//    saveStateHandle: SavedStateHandle,
    exchangeRepository: ExchangeRepository
) : ViewModel() {
    val currencyList: LiveData<List<Currency>> = exchangeRepository.getCurrencyList()
}
