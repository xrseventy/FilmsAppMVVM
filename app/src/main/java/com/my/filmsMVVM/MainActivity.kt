package com.my.filmsMVVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.my.filmsMVVM.ui.ui.FilmsListFragment
import com.my.weather.R

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
    //https://www.metaweather.com/api/
    //https://openweathermap.org/api
}