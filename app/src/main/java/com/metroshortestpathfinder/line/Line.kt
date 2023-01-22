package com.metroshortestpathfinder.line

import android.content.Context
import com.metroshortestpathfinder.Station

abstract class Line(context: Context) {
    abstract var stationNames: MutableList<String>
    abstract var startStation: String
    abstract var endStation: String
}