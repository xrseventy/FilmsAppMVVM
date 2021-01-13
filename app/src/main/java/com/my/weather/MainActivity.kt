package com.my.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.my.weather.ui.ui.FutureListWeatherFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FutureListWeatherFragment.newInstance())
                    .commitNow()
        }
    }
    //https://www.metaweather.com/api/
    //https://openweathermap.org/api
}