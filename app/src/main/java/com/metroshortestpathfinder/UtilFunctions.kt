package com.metroshortestpathfinder

import android.annotation.SuppressLint
import android.content.Context
import com.metroshortestpathfinder.line.*

@SuppressLint("DiscouragedApi")
fun initiateStations(context: Context) {
    var currentId = -1
    for (i in 1..7) {
        val curLineStationNames = context.resources.getStringArray(
            context.resources.getIdentifier(
                "line$i",
                "array",
                context.packageName
            )
        )
        for (stationIndex in curLineStationNames.indices) {
            try {
                stationList.add(Station(++currentId, curLineStationNames[stationIndex], i))
                if (stationList.last().lineNum == stationList[stationList.lastIndex - 1].lineNum) {
                    graph.addEdge(
                        stationList.last().id,
                        stationList[stationList.lastIndex - 1].id,
                        1
                    )
                    graph.addEdge(
                        stationList[stationList.lastIndex - 1].id,
                        stationList.last().id,
                        1
                    )
                }
            } catch (_: Exception) {
            }
        }
    }
    connectDupIntersections(context)
}

fun findIdFromName(name: String): MutableList<Int> {
    val res = mutableListOf<Int>()
    stationList.forEach {
        if (it.name == name)
            res.add(it.id)
    }
    return res
}

fun findAndConnect(stationName: String) {
    val foundedNames = findIdFromName(stationName)
    graph.addEdge(foundedNames!![0], foundedNames[1], 2)
    graph.addEdge(foundedNames[1], foundedNames[0], 2)
}

fun findStationNameFromId(id: Int) = stationList.find { it.id == id }?.name!!

private fun connectDupIntersections(context: Context) {
    context.resources.getStringArray(R.array.intersections).forEach {
        findAndConnect(it)
    }
}

fun findDirectionForStartStation(context: Context, startId: Int, nextId: Int): String {
    val resPair = startWayFinderHelper(context, startId, nextId)
    if (resPair.second) {
        when (resPair.first) {
            1 -> return LineOne().endStation
            2 -> return LineTwo().endStation
            3 -> return LineThree().endStation
            4 -> return LineFour().endStation
            5 -> return LineFIve().endStation
            6 -> return LineSix().endStation
            7 -> return LineSeven().endStation
        }
    } else {
        when (resPair.first) {
            1 -> return LineOne().startStation
            2 -> return LineTwo().startStation
            3 -> return LineThree().startStation
            4 -> return LineFour().startStation
            5 -> return LineFIve().startStation
            6 -> return LineSix().startStation
            7 -> return LineSeven().startStation
        }
    }
    return ""
}

private fun startWayFinderHelper(
    context: Context,
    startId: Int,
    nextId: Int
): Pair<Int, Boolean> {
    for (i in 1..7) {
        val curLineStationNames = context.resources.getStringArray(
            context.resources.getIdentifier(
                "line$i",
                "array",
                context.packageName
            )
        )
        if (curLineStationNames.contains(findStationNameFromId(startId)) && curLineStationNames.contains(
                findStationNameFromId(nextId)
            )
        ) {
            return Pair(
                i,
                curLineStationNames.indexOf(findStationNameFromId(startId)) < curLineStationNames.indexOf(
                    findStationNameFromId(nextId)
                )
            )
        }
    }
    return Pair(0, false)
}