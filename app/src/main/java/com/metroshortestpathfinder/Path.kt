package com.metroshortestpathfinder

class Path(private var intersectionNames: Array<String>) {
    var pathNames = mutableListOf<String>()
     var ratio = 100
    fun calculateRatio() {
        for (stationName in pathNames) {
            if (intersectionNames.contains(stationName))
                ratio--
        }
    }
}
