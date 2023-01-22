package com.metroshortestpathfinder

import android.content.Context
import com.metroshortestpathfinder.line.*

fun initiateStations(context: Context) {

    var currentId = -1
    // initiate stations of line one
    val lineOneStationNames = context.resources.getStringArray(R.array.firstLine)
    for (i in lineOneStationNames.indices) {
        stationList.add(Station(lineOneStationNames[i], ++currentId, LineOne(context)))
    }
    // initiate stations of line two
    val lineTwoStationNames = context.resources.getStringArray(R.array.secondLine)
    for (i in lineTwoStationNames.indices) {
        if (!stationList.any { station: Station -> station.name == lineTwoStationNames[i] })
            stationList.add(
                Station(
                    lineTwoStationNames[i],
                    ++currentId,
                    LineTwo(context)
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
                    LineThree(context)
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
                    LineFour(context)
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
                    LineFIve(context)
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
                    LineSix(context)
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
                    LineSeven(context)
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
    labelIntersections()
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


fun findStationFromId(id: Int): Station {
    return stationList.find { it.id == id }!!
}

//this func can be better
private fun labelIntersections() {
    //line 1
    stationList.find { it.name == "شهید بهشتی" }?.isIntersection = true
    stationList.find { it.name == "دروازه دولت" }?.isIntersection = true
    stationList.find { it.name == "امام خمینی" }?.isIntersection = true
    stationList.find { it.name == "میدان محمدیه" }?.isIntersection = true
    //line 2
    stationList.find { it.name == "امام حسین" }?.isIntersection = true
    stationList.find { it.name == "دروازه شمیران" }?.isIntersection = true
    stationList.find { it.name == "شهید نواب صفوی" }?.isIntersection = true
    stationList.find { it.name == "شادمان" }?.isIntersection = true
    stationList.find { it.name == "تهران (صادقیه)" }?.isIntersection = true
    //line 3
    stationList.find { it.name == "تیاتر شهر" }?.isIntersection = true
    stationList.find { it.name == "مهدیه" }?.isIntersection = true
    //line 4
    stationList.find { it.name == "میدان شهدا" }?.isIntersection = true
    stationList.find { it.name == "توحید" }?.isIntersection = true
    stationList.find { it.name == "ارم سبز" }?.isIntersection = true
    //line 6
    stationList.find { it.name == "دانشگاه تربیت مدرس" }?.isIntersection = true
}