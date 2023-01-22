package com.metroshortestpathfinder.line

import android.content.Context
import com.metroshortestpathfinder.R
import com.metroshortestpathfinder.stationList

class LineSix (context: Context) : Line(context) {
    override var stationNames =
        context.resources.getStringArray(R.array.sixthLine).toMutableList()
    override var startStation = stationNames.find { it == "شهید ستاری" }!!
    override var endStation = stationNames.find { it == "دولت آباد" }!!
}