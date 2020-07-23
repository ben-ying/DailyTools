package com.yjh.dt.dailytools.view

import android.os.Bundle
import com.yjh.dt.dailytools.R
import com.yjh.dt.dailytools.view.base.BaseActivity
import org.jetbrains.annotations.NotNull

class MainActivity: BaseActivity(), ToolListFragment.OnListFragmentInteractionListener {

    @NotNull
    private lateinit var mToolListFragment : ToolListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToolListFragment = ToolListFragment()
        replaceFragment(R.id.main_container, mToolListFragment, false)
    }

    override fun onListFragmentInteraction(position: Int) {
        when(position) {
            0 -> {
                replaceFragment(R.id.main_container, ExchangeFragment(), true)
            }
        }
    }
}
