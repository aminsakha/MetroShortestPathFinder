package com.metroshortestpathfinder.line

import android.content.Context
import com.metroshortestpathfinder.R
import com.metroshortestpathfinder.stationList

class LineThree(context: Context) : Line(context) {
    override var stationNames =
        context.resources.getStringArray(R.array.thirdLine).toMutableList()
    override var startStation = stationNames.find { it == "قایم" }!!
    override var endStation = stationNames.find { it == "آزادگان" }!!
}