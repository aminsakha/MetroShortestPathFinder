package com.metroshortestpathfinder.line

import android.content.Context
import com.metroshortestpathfinder.R
import com.metroshortestpathfinder.stationList

class LineOne(context: Context) : Line(context) {
    override var stationNames =
        context.resources.getStringArray(R.array.firstLine).toMutableList()
    override var startStation = stationNames.find { it == "تجریش" }!!
    override var endStation = stationNames.find { it == "کهریزک" }!!
}