package com.metroshortestpathfinder

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
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
    connectDupIntersections()
}

fun findIdFromName(name: String): MutableList<Int>? {
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
    graph.addEdge(foundedNames!![1], foundedNames[0], 2)
}

fun findStationNameFromId(id: Int): String {
    var res = stationList.find { it.id == id }?.name!!
//    res += " : " + stationList.find { it.id == id }!!.id
    return res
}

private fun connectDupIntersections() {
    findAndConnect("شهید بهشتی")
    findAndConnect("دروازه دولت")
    findAndConnect("امام خمینی")
    findAndConnect("میدان محمدیه")
    findAndConnect("امام حسین")
    findAndConnect("دروازه شمیران")
    findAndConnect("شهید نواب صفوی")
    findAndConnect("شادمان")
    findAndConnect("تهران (صادقیه)")
    findAndConnect("تیاتر شهر")
    findAndConnect("مهدیه")
    findAndConnect("میدان شهدا")
    findAndConnect("توحید")
    findAndConnect("ارم سبز")
    findAndConnect("دانشگاه تربیت مدرس")
}