package com.metroshortestpathfinder

import LineNumber
import android.content.Context
import android.util.Log
import java.util.ArrayList

fun initiateStations(context: Context) {

    var currentId = -1
    // initiate stations of line one
    val lineOneStationNames = context.resources.getStringArray(R.array.firstLine)
    for (i in lineOneStationNames.indices) {
        stationList.add(Station(lineOneStationNames[i], ++currentId, LineNumber.ONE))
    }
    // initiate stations of line two
    val lineTwoStationNames = context.resources.getStringArray(R.array.secondLine)
    for (i in lineTwoStationNames.indices) {
        if (!stationList.any { station: Station -> station.name == lineTwoStationNames[i] })
            stationList.add(
                Station(
                    lineTwoStationNames[i],
                    ++currentId,
                    LineNumber.TWO
                )
            )
    }
    // initiate stations of line three
    val lineThreeStationNames = context.resources.getStringArray(R.array.thirdLine)
    for (i in lineThreeStationNames.indices) {
        if (!stationList.any { station: Station -> station.name == lineThreeStationNames[i] })
            stationList.add(
                Station(
                    lineThreeStationNames[i],
                    ++currentId,
                    LineNumber.THREE
                )
            )
    }
    // initiate stations of line four
    val lineFourStationNames = context.resources.getStringArray(R.array.forthLine)
    for (i in lineFourStationNames.indices) {
        if (!stationList.any { station: Station -> station.name == lineFourStationNames[i] })
            stationList.add(
                Station(
                    lineFourStationNames[i],
                    ++currentId,
                    LineNumber.FOUR
                )
            )
    }
    // initiate stations of line five
    val lineFiveStationNames = context.resources.getStringArray(R.array.fifthLine)
    for (i in lineFiveStationNames.indices) {
        if (!stationList.any { station: Station -> station.name == lineFiveStationNames[i] })
            stationList.add(
                Station(
                    lineFiveStationNames[i],
                    ++currentId,
                    LineNumber.FIVE
                )
            )
    }
    // initiate stations of line six
    val lineSixStationNames = context.resources.getStringArray(R.array.sixthLine)
    for (i in lineSixStationNames.indices) {
        if (!stationList.any { station: Station -> station.name == lineSixStationNames[i] })
            stationList.add(
                Station(
                    lineSixStationNames[i],
                    ++currentId,
                    LineNumber.SIX
                )
            )
    }
    // initiate stations of line seven
    val linSevenStationNames = context.resources.getStringArray(R.array.seventhLine)
    for (i in linSevenStationNames.indices) {
        if (!stationList.any { station: Station -> station.name == linSevenStationNames[i] })
            stationList.add(
                Station(
                    linSevenStationNames[i],
                    ++currentId,
                    LineNumber.SEVEN
                )
            )
    }
    drawEdges(lineOneStationNames.toMutableList())
    drawEdges(lineTwoStationNames.toMutableList())
    drawEdges(lineThreeStationNames.toMutableList())
    drawEdges(lineFourStationNames.toMutableList())
    drawEdges(lineFiveStationNames.toMutableList())
    drawEdges(lineSixStationNames.toMutableList())
    drawEdges(linSevenStationNames.toMutableList())
}

private fun drawEdges(list: MutableList<String>) {
    for (i in 0 until stationList.size) {
        adj.add(ArrayList())
    }
    for (i in list.indices) {
        try {
            addEdge(findIdFromName(list[i])!!, findIdFromName(list[i + 1])!!)
        } catch (_: IndexOutOfBoundsException) {
        }
    }

}

 fun findIdFromName(name: String): Int? {
    return stationList.find { it.name == name }?.id
}

fun findStationFromId(id: Int): Station? {
    return stationList.find { it.id == id }
}