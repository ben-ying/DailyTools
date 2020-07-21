package com.yjh.dt.dailytools.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yjh.dt.dailytools.R
import com.yjh.dt.dailytools.view.dummy.DummyContent
import org.jetbrains.annotations.NotNull

class MainActivity : AppCompatActivity(), ToolListFragment.OnListFragmentInteractionListener {

    @NotNull
    private var mToolListFragment : ToolListFragment? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToolListFragment = ToolListFragment();
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, mToolListFragment!!).commit();
        supportFragmentManager.beginTransaction().show(mToolListFragment!!);
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO("Not yet implemented")
    }
}
