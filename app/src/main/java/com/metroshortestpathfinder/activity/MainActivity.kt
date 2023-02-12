package com.metroshortestpathfinder.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.metroshortestpathfinder.R
import com.metroshortestpathfinder.Result
import com.metroshortestpathfinder.initiateStations

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}