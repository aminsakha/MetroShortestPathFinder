package com.metroshortestpathfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.metroshortestpathfinder.Result

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiateStations(this)
        val startNodeName = "سهروردی"
        val destNodeName = "میدان جهاد"
        val res = Result(this, startNodeName, destNodeName)
        Log.d("output", res.printResult().toString())
    }
}