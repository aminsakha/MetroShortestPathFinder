package com.metroshortestpathfinder

import android.content.Context

class Result(
    context: Context,
    private var startStationName: String,
    private var destStationName: String
) {
    private val resList = mutableListOf<String>()
    private val intersectionNames: Array<String> =
        context.resources.getStringArray(R.array.intersections)

    fun printUniqueResult(): MutableList<String> {
        graph.findShortestPath(
            findIdFromName(startStationName)!![0],
            findIdFromName(destStationName)!![0]
        )
        resList.myAdd("حرکت از ایستگاه ")
        resList.myAdd(startStationName)
        resList.myAdd(" به سمت ")
        resList.add(
            findDirectionForStartStation(
                findStationNameFromId(idListResult[0]),
                findStationNameFromId(idListResult[1])
            )
        )

        for (i in 1 until idListResult.size) {
            val currStationName = findStationNameFromId(idListResult[i])
            if (intersectionNames.contains(currStationName)) {
                try {
                    if (resList.contains(getDirection(idListResult[i], idListResult[i + 1]))) {
                        resList.add(currStationName)
                        continue
                    }
                    resList.add(currStationName)
                    resList.add(" به سمت ")
                    resList.add(getDirection(idListResult[i], idListResult[i + 1]))
                    continue
                } catch (_: IndexOutOfBoundsException) {
                }
            }
            resList.add(currStationName)
        }
        return resList
    }

    fun selectBestBetweenTwoPaths() {

    }
}