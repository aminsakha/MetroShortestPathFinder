package com.metroshortestpathfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiateStations(this)
        Log.d("output", stationList.toString())
        //Log.d("stations", "$stationList ")
//        val source = findIdFromName("شادمان")!!
//        val dest = findIdFromName("بسیج")!!
//
//        printShortestDistance(adj, source, dest)
    }
}