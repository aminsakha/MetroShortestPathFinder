package com.metroshortestpathfinder.line

import android.content.Context
import com.metroshortestpathfinder.R
import com.metroshortestpathfinder.stationList

class LineFIve(context: Context) : Line(context) {
    override var stationNames =
        context.resources.getStringArray(R.array.fifthLine).toMutableList()
    override var startStation = stationNames.find { it == "ارم سبز" }!!
    override var endStation = stationNames.find { it == "گلشهر" }!!
}