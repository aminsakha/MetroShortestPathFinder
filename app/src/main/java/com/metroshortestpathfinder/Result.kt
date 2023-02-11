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

    private fun printUniqueResult(
        whichWayForStartNode: Int,
        whichWayForEndNode: Int
    ): MutableList<String> {
        graph.findShortestPath(
            findIdFromName(startStationName)[whichWayForStartNode],
            findIdFromName(destStationName)[whichWayForEndNode]
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

    fun printResult(): MutableList<String> {
        val path1 = Path(intersectionNames)
        val path2 = Path(intersectionNames)
        val path3 = Path(intersectionNames)
        val path4 = Path(intersectionNames)
        if (intersectionNames.contains(startStationName) && !intersectionNames.contains(
                destStationName
            )
        ) {
            path1.pathNames = printUniqueResult(0, 0)
            path1.calculateRatio()
            path2.pathNames = printUniqueResult(1, 0)
            path2.calculateRatio()
            return calculateBestPath(path1, path2).pathNames
        } else if (!intersectionNames.contains(startStationName) && intersectionNames.contains(
                destStationName
            )
        ) {
            path1.pathNames.addAll(printUniqueResult(0, 0))
            path1.calculateRatio()
            path2.pathNames.addAll(printUniqueResult(0, 1))
            path2.calculateRatio()
            return calculateBestPath(path1, path2).pathNames
        } else if (intersectionNames.contains(startStationName) && intersectionNames.contains(
                destStationName
            )
        ) {
            path1.pathNames = printUniqueResult(0, 0)
            path1.calculateRatio()
            path2.pathNames = printUniqueResult(1, 1)
            path2.calculateRatio()
            path3.pathNames = printUniqueResult(0, 1)
            path3.calculateRatio()
            path4.pathNames = printUniqueResult(1, 0)
            path4.calculateRatio()
            return calculateBestPath(path1, path2, path3, path4).pathNames
        } else
            return printUniqueResult(0, 0)


    }

    private fun calculateBestPath(vararg paths: Path) = paths.maxBy { it.ratio }
}