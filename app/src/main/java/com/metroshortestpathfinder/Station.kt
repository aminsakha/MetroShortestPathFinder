package com.metroshortestpathfinder

import com.metroshortestpathfinder.line.Line

class Station(
    var name: String,
    var id: Int,
    var lineNum: Line,
    var isIntersection: Boolean = false,
    var isStartNode: Boolean = false,
    var isEndNode: Boolean = false
) {
    override fun toString(): String {
        return "$name : $isStartNode -> $isIntersection"
    }
}