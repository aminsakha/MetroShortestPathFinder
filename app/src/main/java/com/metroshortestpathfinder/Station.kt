package com.metroshortestpathfinder

class Station(
    var id: Int,
    var name: String,
    var lineNum: Int,
    var isIntersection: Boolean = false,
) {
    override fun toString(): String {
        return "$name : $lineNum : $id"
    }
}