package com.yjh.dt.dailytools.di.component

import com.yjh.dt.dailytools.di.module.ExchangeModule
import com.yjh.dt.dailytools.view.ExchangeFragment
import dagger.Component

@Component(modules = [ExchangeModule::class])
interface ExchangeComponent {
    fun inject(exchangeFragment: ExchangeFragment)
}