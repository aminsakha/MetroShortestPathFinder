package com.metroshortestpathfinder.line

import android.content.Context
import com.metroshortestpathfinder.Station

abstract class Line() {
    abstract var startStation: String
    abstract var endStation: String
}