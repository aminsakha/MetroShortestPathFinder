package com.metroshortestpathfinder

import LineNumber

class Station(
    var name: String,
    var id: Int,
    var lineNum: LineNumber,
    var isIntersection: Boolean = false,
    var isStartNode: Boolean = false,
    var isEndNode: Boolean = false
) {
    override fun toString(): String {
        return "$name - > $id"
    }
}