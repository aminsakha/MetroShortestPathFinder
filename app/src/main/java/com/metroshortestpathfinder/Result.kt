package com.metroshortestpathfinder

import android.content.Context
import android.util.Log

class Result(
    private var context: Context,
    private var startStationName: String,
    private var destStationName: String
) {
    private val intersectionNames: Array<String> =
        context.resources.getStringArray(R.array.intersections)

    private fun printUniqueResult(
        whichWayForStartNode: Int,
        whichWayForEndNode: Int,
        path: Path
    ): MutableList<String> {
        val resList = mutableListOf<String>()

        graph.findShortestPath(
            path,
            findIdFromName(startStationName)[whichWayForStartNode],
            findIdFromName(destStationName)[whichWayForEndNode]
        )
        resList.myAdd("حرکت از ایستگاه ")
        resList.myAdd(startStationName)
        resList.myAdd(" به سمت ")
        if (intersectionNames.contains(startStationName))
            resList.add(getDirection(idListResult[0], idListResult[1]))
        else
            resList.add(findDirectionForStartStation(context, idListResult[0], idListResult[1]))

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

    fun printResult(): MutableList<String> {
        val path1 = Path(intersectionNames)
        val path2 = Path(intersectionNames)
        val path3 = Path(intersectionNames)
        val path4 = Path(intersectionNames)
        if (intersectionNames.contains(startStationName) && !intersectionNames.contains(
                destStationName
            )
        ) {
            path1.pathNames = printUniqueResult(0, 0, path1)
            path2.pathNames = printUniqueResult(1, 0, path2)
            return calculateBestPath(path1, path2).pathNames
        } else if (!intersectionNames.contains(startStationName) && intersectionNames.contains(
                destStationName
            )
        ) {
            path1.pathNames.addAll(printUniqueResult(0, 0, path1))
            path2.pathNames.addAll(printUniqueResult(0, 1, path2))
            return calculateBestPath(path1, path2).pathNames
        } else if (intersectionNames.contains(startStationName) && intersectionNames.contains(
                destStationName
            )
        ) {
            path1.pathNames = printUniqueResult(0, 0, path1)
            idListResult.clear()
            path2.pathNames = printUniqueResult(1, 1, path2)
            idListResult.clear()
            path3.pathNames = printUniqueResult(0, 1, path3)
            idListResult.clear()
            path4.pathNames = printUniqueResult(1, 0, path4)
            return calculateBestPath(path1, path2, path3, path4).pathNames
        } else
            return printUniqueResult(0, 0, path1)
    }

    private fun calculateBestPath(vararg paths: Path) = paths.minBy { it.ratio }
}