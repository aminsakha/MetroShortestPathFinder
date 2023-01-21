package com.metroshortestpathfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiateStations(this)
        Log.d("stations", "$stationList ")
//        val source = findIdFromName("فرهنگسرا")!!
//        val dest = findIdFromName("شهید سپهبد قاسم سلیمانی")!!
//
//        printShortestDistance(adj, source, dest)
    }
}