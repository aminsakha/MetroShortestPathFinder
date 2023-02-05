package com.metroshortestpathfinder.line

import android.content.Context
import com.metroshortestpathfinder.R

class LineTwo(context: Context) : Line(context) {
    override var stationNames =
        context.resources.getStringArray(R.array.line2).toMutableList()
    override var startStation = stationNames.find { it == "فرهنگسرا" }!!
    override var endStation = stationNames.find { it == "تهران (صادقیه)" }!!
}