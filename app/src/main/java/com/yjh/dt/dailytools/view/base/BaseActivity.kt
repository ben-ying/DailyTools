package com.yjh.dt.dailytools.view.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.yjh.dt.dailytools.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun replaceFragment(resId: Int, fragment: BaseFragment, addToBackStack: Boolean) {
        val transition: FragmentTransaction = supportFragmentManager.beginTransaction()
        transition.replace(resId, fragment)
        if (addToBackStack) {
            transition.addToBackStack(null)
        }
        transition.commit()
    }
}
