package com.metroshortestpathfinder.line

import android.content.Context
import com.metroshortestpathfinder.R
import com.metroshortestpathfinder.stationList

class LineFour(context: Context) : Line(context) {
    override var stationNames =
        context.resources.getStringArray(R.array.line4).toMutableList()
    override var startStation = stationNames.find { it == "شهید کلاهدوز" }!!
    override var endStation = stationNames.find { it == "ارم سبز" }!!
}