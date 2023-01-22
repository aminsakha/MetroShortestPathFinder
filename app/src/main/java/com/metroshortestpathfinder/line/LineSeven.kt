package com.metroshortestpathfinder.line

import android.content.Context
import com.metroshortestpathfinder.R
import com.metroshortestpathfinder.stationList

class LineSeven (context: Context) : Line(context) {
    override var stationNames =
        context.resources.getStringArray(R.array.seventhLine).toMutableList()
    override var startStation = stationNames.find { it == "میدان صنعت" }!!
    override var endStation = stationNames.find { it == "بسیج" }!!
}