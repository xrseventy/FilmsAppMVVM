package com.xrseventy.listfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xrseventy.listfilm.ui.fragment.FilmsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FilmsListFragment.newInstance())
                    .commitNow()
        }
    }
}